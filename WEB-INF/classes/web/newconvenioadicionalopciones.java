package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioadicionalopciones extends GXProcedure
{
   public newconvenioadicionalopciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioadicionalopciones.class ), "" );
   }

   public newconvenioadicionalopciones( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal aP7 ,
                        int aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal aP7 ,
                             int aP8 )
   {
      newconvenioadicionalopciones.this.AV8CliCod = aP0;
      newconvenioadicionalopciones.this.AV9CliPaiConve = aP1;
      newconvenioadicionalopciones.this.AV10CliConvenio = aP2;
      newconvenioadicionalopciones.this.AV11ConveAdicod = aP3;
      newconvenioadicionalopciones.this.AV12ConveAdiOpcCod = aP4;
      newconvenioadicionalopciones.this.AV13ConveAdiOpcFor = aP5;
      newconvenioadicionalopciones.this.AV14ConveAdiOpcDes = aP6;
      newconvenioadicionalopciones.this.AV15ConveAdiOpcAli = aP7;
      newconvenioadicionalopciones.this.AV16ConveAdiOpcRelSec = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE convenio_adicionalalicuotas

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      A1565CliConvenio = AV10CliConvenio ;
      A996ConveAdicod = AV11ConveAdicod ;
      A1011ConveAdiOpcCod = AV12ConveAdiOpcCod ;
      A1021ConveAdiOpcFor = AV13ConveAdiOpcFor ;
      A1012ConveAdiOpcDes = AV14ConveAdiOpcDes ;
      A1013ConveAdiOpcAli = AV15ConveAdiOpcAli ;
      A1900ConveAdiOpcRelSec = AV16ConveAdiOpcRelSec ;
      A2051ConveAdiOpcRelRef = "" ;
      A2052ConveAdiOpcOld = "" ;
      /* Using cursor P01PB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod), A1021ConveAdiOpcFor, A1012ConveAdiOpcDes, A1013ConveAdiOpcAli, Integer.valueOf(A1900ConveAdiOpcRelSec), A2051ConveAdiOpcRelRef, A2052ConveAdiOpcOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioadicionalopciones");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      A2051ConveAdiOpcRelRef = "" ;
      A2052ConveAdiOpcOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioadicionalopciones__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9CliPaiConve ;
   private short AV12ConveAdiOpcCod ;
   private short A1564CliPaiConve ;
   private short A1011ConveAdiOpcCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV16ConveAdiOpcRelSec ;
   private int GX_INS209 ;
   private int A3CliCod ;
   private int A1900ConveAdiOpcRelSec ;
   private java.math.BigDecimal AV15ConveAdiOpcAli ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private String AV10CliConvenio ;
   private String AV11ConveAdicod ;
   private String AV13ConveAdiOpcFor ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1021ConveAdiOpcFor ;
   private String Gx_emsg ;
   private String A2052ConveAdiOpcOld ;
   private String AV14ConveAdiOpcDes ;
   private String A1012ConveAdiOpcDes ;
   private String A2051ConveAdiOpcRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioadicionalopciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01PB2", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalalicuotas(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, ConveAdiOpcRelRef, ConveAdiOpcOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
      }
   }

}

