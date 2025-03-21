#include <stdio.h>
#include <stdlib.h>
#include <oci.h>

void check_error(OCIError* errhp) {
    text errbuf[512];
    sb4 errcode = 0;
    OCIErrorGet(errhp, 1, NULL, &errcode, errbuf, sizeof(errbuf), OCI_HTYPE_ERROR);
    printf("Oracle Error: %s\n", errbuf);
}

int main() {
    OCIEnv* envhp;
    OCIError* errhp;
    OCISvcCtx* svchp;
    OCISession* usrhp;
    OCIServer* srvhp;
    OCIStmt* stmthp;
    sword status;

    // DB 로그인 정보
    char* username = "C##DEV";
    char* password = "2941";
    char* dbname = "localhost:1521/xe";

    // 환경 핸들 초기화
    OCIEnvCreate(&envhp, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);
    OCIHandleAlloc(envhp, (void**)&errhp, OCI_HTYPE_ERROR, 0, NULL);
    OCIHandleAlloc(envhp, (void**)&srvhp, OCI_HTYPE_SERVER, 0, NULL);
    OCIServerAttach(srvhp, errhp, (OraText*)dbname, strlen(dbname), OCI_DEFAULT);
    OCIHandleAlloc(envhp, (void**)&svchp, OCI_HTYPE_SVCCTX, 0, NULL);
    OCIAttrSet(svchp, OCI_HTYPE_SVCCTX, srvhp, 0, OCI_ATTR_SERVER, errhp);
    OCIHandleAlloc(envhp, (void**)&usrhp, OCI_HTYPE_SESSION, 0, NULL);
    OCIAttrSet(usrhp, OCI_HTYPE_SESSION, username, strlen(username), OCI_ATTR_USERNAME, errhp);
    OCIAttrSet(usrhp, OCI_HTYPE_SESSION, password, strlen(password), OCI_ATTR_PASSWORD, errhp);
    OCISessionBegin(svchp, errhp, usrhp, OCI_CRED_RDBMS, OCI_DEFAULT);
    OCIAttrSet(svchp, OCI_HTYPE_SVCCTX, usrhp, 0, OCI_ATTR_SESSION, errhp);
    printf("Oracle DB 연결 성공!\n");

    // INSERT 문 실행
    char* insert_sql = "INSERT INTO test_customer (CUSTOMER_ID, NAME, PHONE, BIRTH_DATE) VALUES (1, 'Alice', '010-1111-1111', '1999-08-16')";
    OCIHandleAlloc(envhp, (void**)&stmthp, OCI_HTYPE_STMT, 0, NULL);
    OCIStmtPrepare(stmthp, errhp, (text*)insert_sql, strlen(insert_sql), OCI_NTV_SYNTAX, OCI_DEFAULT);
    OCIStmtExecute(svchp, stmthp, errhp, 1, 0, NULL, NULL, OCI_COMMIT_ON_SUCCESS);
    printf("데이터 삽입 성공!\n");

    // INSERT 문 실행
    char* insert_sql2 = "INSERT INTO test_customer (CUSTOMER_ID, NAME, PHONE, BIRTH_DATE) VALUES (2, 'Realkk', '010-2222-2222', '1999-08-16')";
    OCIHandleAlloc(envhp, (void**)&stmthp, OCI_HTYPE_STMT, 0, NULL);
    OCIStmtPrepare(stmthp, errhp, (text*)insert_sql2, strlen(insert_sql2), OCI_NTV_SYNTAX, OCI_DEFAULT);
    OCIStmtExecute(svchp, stmthp, errhp, 1, 0, NULL, NULL, OCI_COMMIT_ON_SUCCESS);
    printf("데이터 삽입 성공!\n");

    // UPDATE 문 실행
    char* update_sql = "UPDATE test_customer SET NAME = 'realkk2' WHERE ID = 1";
    OCIStmtPrepare(stmthp, errhp, (text*)update_sql, strlen(update_sql), OCI_NTV_SYNTAX, OCI_DEFAULT);
    OCIStmtExecute(svchp, stmthp, errhp, 1, 0, NULL, NULL, OCI_COMMIT_ON_SUCCESS);
    printf("데이터 업데이트 성공!\n");

    // DELETE 문 실행
    char* delete_sql = "DELETE FROM test_customer WHERE ID = 2";
    OCIStmtPrepare(stmthp, errhp, (text*)delete_sql, strlen(delete_sql), OCI_NTV_SYNTAX, OCI_DEFAULT);
    OCIStmtExecute(svchp, stmthp, errhp, 1, 0, NULL, NULL, OCI_COMMIT_ON_SUCCESS);
    printf("데이터 삭제 성공!\n");

    // 연결 종료
    OCIHandleFree(stmthp, OCI_HTYPE_STMT);
    OCILogoff(svchp, errhp);
    OCIHandleFree(usrhp, OCI_HTYPE_SESSION);
    OCIHandleFree(svchp, OCI_HTYPE_SVCCTX);
    OCIHandleFree(srvhp, OCI_HTYPE_SERVER);
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);
    printf("연결 종료\n");

    return 0;
}
