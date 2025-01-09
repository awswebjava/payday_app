package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioadicional extends GXProcedure
{
   public newconvenioadicional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioadicional.class ), "" );
   }

   public newconvenioadicional( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.math.BigDecimal aP5 ,
                        String aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.math.BigDecimal aP5 ,
                             String aP6 ,
                             int aP7 )
   {
      newconvenioadicional.this.AV8CliCod = aP0;
      newconvenioadicional.this.AV9CliPaiConve = aP1;
      newconvenioadicional.this.AV10CliConvenio = aP2;
      newconvenioadicional.this.AV11ConveAdiDescri = aP3;
      newconvenioadicional.this.AV12ConveAdicod = aP4;
      newconvenioadicional.this.AV13ConveAdiAli = aP5;
      newconvenioadicional.this.AV14ConveAdiTipo = aP6;
      newconvenioadicional.this.AV15ConveAdiRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE convenio_adicional

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      A1565CliConvenio = AV10CliConvenio ;
      A997ConveAdiDescri = AV11ConveAdiDescri ;
      A996ConveAdicod = AV12ConveAdicod ;
      A998ConveAdiAli = AV13ConveAdiAli ;
      A1803ConveAdiTipo = AV14ConveAdiTipo ;
      A1901ConveAdiRelSec = AV15ConveAdiRelSec ;
      n1901ConveAdiRelSec = false ;
      A2046ConveAdiRelRef = "" ;
      A2047ConveAdiOld = "" ;
      /* Using cursor P01P82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A997ConveAdiDescri, A998ConveAdiAli, A1803ConveAdiTipo, Boolean.valueOf(n1901ConveAdiRelSec), Integer.valueOf(A1901ConveAdiRelSec), A2046ConveAdiRelRef, A2047ConveAdiOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioadicional");
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
      A997ConveAdiDescri = "" ;
      A996ConveAdicod = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      A1803ConveAdiTipo = "" ;
      A2046ConveAdiRelRef = "" ;
      A2047ConveAdiOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioadicional__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15ConveAdiRelSec ;
   private int GX_INS207 ;
   private int A3CliCod ;
   private int A1901ConveAdiRelSec ;
   private java.math.BigDecimal AV13ConveAdiAli ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private String AV10CliConvenio ;
   private String AV12ConveAdicod ;
   private String AV14ConveAdiTipo ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1803ConveAdiTipo ;
   private String Gx_emsg ;
   private boolean n1901ConveAdiRelSec ;
   private String A2047ConveAdiOld ;
   private String AV11ConveAdiDescri ;
   private String A997ConveAdiDescri ;
   private String A2046ConveAdiRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioadicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01P82", "SAVEPOINT gxupdate;INSERT INTO convenio_adicional(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, ConveAdiInfo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setString(7, (String)parms[6], 20);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(8, ((Number) parms[8]).intValue());
               }
               stmt.setVarchar(9, (String)parms[9], 40, false);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               return;
      }
   }

}

