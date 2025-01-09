package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_conveniotiposdetrabajo extends GXProcedure
{
   public new_conveniotiposdetrabajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_conveniotiposdetrabajo.class ), "" );
   }

   public new_conveniotiposdetrabajo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal aP9 ,
                        java.math.BigDecimal aP10 ,
                        java.math.BigDecimal aP11 ,
                        short aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.math.BigDecimal aP11 ,
                             short aP12 )
   {
      new_conveniotiposdetrabajo.this.AV20CliCod = aP0;
      new_conveniotiposdetrabajo.this.AV8CliPaiConve = aP1;
      new_conveniotiposdetrabajo.this.AV19CliConvenio = aP2;
      new_conveniotiposdetrabajo.this.AV9PaiTipoTraId = aP3;
      new_conveniotiposdetrabajo.this.AV18ConveHsDia = aP4;
      new_conveniotiposdetrabajo.this.AV17ConveHsSem = aP5;
      new_conveniotiposdetrabajo.this.AV16ConveTarifaXLim = aP6;
      new_conveniotiposdetrabajo.this.AV10ConveTarifaRec = aP7;
      new_conveniotiposdetrabajo.this.AV13ConveHsMaxDia = aP8;
      new_conveniotiposdetrabajo.this.AV15ConveHsMaxSem = aP9;
      new_conveniotiposdetrabajo.this.AV12ConveHsMaxMes = aP10;
      new_conveniotiposdetrabajo.this.AV11ConveHsMaxAnu = aP11;
      new_conveniotiposdetrabajo.this.AV14ConveHsRelSec = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE convenio_tiposdetrabajo

      */
      A3CliCod = AV20CliCod ;
      A1564CliPaiConve = AV8CliPaiConve ;
      A1565CliConvenio = AV19CliConvenio ;
      A1294PaiTipoTraId = AV9PaiTipoTraId ;
      A1323ConveHsDia = AV18ConveHsDia ;
      A1324ConveHsSem = AV17ConveHsSem ;
      A1325ConveTarifaXLim = AV16ConveTarifaXLim ;
      A1349ConveTarifaRec = AV10ConveTarifaRec ;
      A1391ConveHsMaxDia = AV13ConveHsMaxDia ;
      A1392ConveHsMaxSem = AV15ConveHsMaxSem ;
      A1393ConveHsMaxMes = AV12ConveHsMaxMes ;
      A1394ConveHsMaxAnu = AV11ConveHsMaxAnu ;
      A2063ConveHsRelSec = AV14ConveHsRelSec ;
      A2064ConveHsRelRef = "" ;
      A2065ConveHsOld = "" ;
      /* Using cursor P01WX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId, A1323ConveHsDia, A1324ConveHsSem, A1325ConveTarifaXLim, A1349ConveTarifaRec, A1391ConveHsMaxDia, A1392ConveHsMaxSem, A1393ConveHsMaxMes, A1394ConveHsMaxAnu, Integer.valueOf(A2063ConveHsRelSec), A2064ConveHsRelRef, A2065ConveHsOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_tiposdetrabajo");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "new_conveniotiposdetrabajo");
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
      A1294PaiTipoTraId = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1325ConveTarifaXLim = DecimalUtil.ZERO ;
      A1349ConveTarifaRec = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      A2064ConveHsRelRef = "" ;
      A2065ConveHsOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_conveniotiposdetrabajo__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8CliPaiConve ;
   private short AV14ConveHsRelSec ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int GX_INS217 ;
   private int A3CliCod ;
   private int A2063ConveHsRelSec ;
   private java.math.BigDecimal AV18ConveHsDia ;
   private java.math.BigDecimal AV17ConveHsSem ;
   private java.math.BigDecimal AV16ConveTarifaXLim ;
   private java.math.BigDecimal AV10ConveTarifaRec ;
   private java.math.BigDecimal AV13ConveHsMaxDia ;
   private java.math.BigDecimal AV15ConveHsMaxSem ;
   private java.math.BigDecimal AV12ConveHsMaxMes ;
   private java.math.BigDecimal AV11ConveHsMaxAnu ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1325ConveTarifaXLim ;
   private java.math.BigDecimal A1349ConveTarifaRec ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private String AV19CliConvenio ;
   private String AV9PaiTipoTraId ;
   private String A1565CliConvenio ;
   private String A1294PaiTipoTraId ;
   private String Gx_emsg ;
   private String A2065ConveHsOld ;
   private String A2064ConveHsRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class new_conveniotiposdetrabajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01WX2", "SAVEPOINT gxupdate;INSERT INTO convenio_tiposdetrabajo(CliCod, CliPaiConve, CliConvenio, PaiTipoTraId, ConveHsDia, ConveHsSem, ConveTarifaXLim, ConveTarifaRec, ConveHsMaxDia, ConveHsMaxSem, ConveHsMaxMes, ConveHsMaxAnu, ConveHsRelSec, ConveHsRelRef, ConveHsOld, ConveHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 1);
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setVarchar(14, (String)parms[13], 40, false);
               stmt.setNLongVarchar(15, (String)parms[14], false);
               return;
      }
   }

}

