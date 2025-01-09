package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newempresabanco extends GXProcedure
{
   public newempresabanco( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newempresabanco.class ), "" );
   }

   public newempresabanco( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      newempresabanco.this.AV15CliCod = aP0;
      newempresabanco.this.AV12EmpCod = aP1;
      newempresabanco.this.AV11EmpBanCod = aP2;
      newempresabanco.this.AV13EmpBanCBU = aP3;
      newempresabanco.this.AV9EmpBanSuc = aP4;
      newempresabanco.this.AV8EmpBanTipCuen = aP5;
      newempresabanco.this.AV14EmpCuentaBanc = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE EmpresaBancos

      */
      A3CliCod = AV15CliCod ;
      A1EmpCod = AV12EmpCod ;
      A1966EmpBanCod = AV11EmpBanCod ;
      A1968EmpBanCBU = AV13EmpBanCBU ;
      A1969EmpBanSuc = AV9EmpBanSuc ;
      A1970EmpBanTipCuen = AV8EmpBanTipCuen ;
      A1971EmpCuentaBanc = AV14EmpCuentaBanc ;
      /* Using cursor P02982 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1966EmpBanCod, A1968EmpBanCBU, A1969EmpBanSuc, A1970EmpBanTipCuen, A1971EmpCuentaBanc});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("EmpresaBancos");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newempresabanco");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1966EmpBanCod = "" ;
      A1968EmpBanCBU = "" ;
      A1969EmpBanSuc = "" ;
      A1970EmpBanTipCuen = "" ;
      A1971EmpCuentaBanc = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newempresabanco__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int GX_INS259 ;
   private int A3CliCod ;
   private String AV11EmpBanCod ;
   private String AV8EmpBanTipCuen ;
   private String A1966EmpBanCod ;
   private String A1970EmpBanTipCuen ;
   private String Gx_emsg ;
   private String AV13EmpBanCBU ;
   private String AV9EmpBanSuc ;
   private String AV14EmpCuentaBanc ;
   private String A1968EmpBanCBU ;
   private String A1969EmpBanSuc ;
   private String A1971EmpCuentaBanc ;
   private IDataStoreProvider pr_default ;
}

final  class newempresabanco__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02982", "SAVEPOINT gxupdate;INSERT INTO EmpresaBancos(CliCod, EmpCod, EmpBanCod, EmpBanCBU, EmpBanSuc, EmpBanTipCuen, EmpCuentaBanc) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 6);
               stmt.setVarchar(4, (String)parms[3], 22, false);
               stmt.setVarchar(5, (String)parms[4], 30, false);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setVarchar(7, (String)parms[6], 20, false);
               return;
      }
   }

}

