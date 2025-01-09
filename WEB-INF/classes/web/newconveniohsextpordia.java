package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconveniohsextpordia extends GXProcedure
{
   public newconveniohsextpordia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconveniohsextpordia.class ), "" );
   }

   public newconveniohsextpordia( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        short aP3 ,
                        String aP4 ,
                        byte aP5 ,
                        String aP6 ,
                        java.math.BigDecimal aP7 ,
                        java.math.BigDecimal aP8 ,
                        String aP9 ,
                        int aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             short aP3 ,
                             String aP4 ,
                             byte aP5 ,
                             String aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             String aP9 ,
                             int aP10 )
   {
      newconveniohsextpordia.this.AV8CliCod = aP0;
      newconveniohsextpordia.this.AV9CliPaiConve = aP1;
      newconveniohsextpordia.this.AV10CliConvenio = aP2;
      newconveniohsextpordia.this.AV11ConveHsExSec = aP3;
      newconveniohsextpordia.this.AV12ConvHsPDiaTipTra = aP4;
      newconveniohsextpordia.this.AV13ConveHsPDiaDia = aP5;
      newconveniohsextpordia.this.AV14ConveHsPDiaDesde = aP6;
      newconveniohsextpordia.this.AV15ConveTarifaPDia = aP7;
      newconveniohsextpordia.this.AV16ConveTarifaPDRec = aP8;
      newconveniohsextpordia.this.AV18ConveTarifaPDCri = aP9;
      newconveniohsextpordia.this.AV17ConveHsPDiaRelSec = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Convenio_horasextras_porDia

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      A1565CliConvenio = AV10CliConvenio ;
      A1327ConveHsExSec = AV11ConveHsExSec ;
      A1326ConvHsPDiaTipTra = AV12ConvHsPDiaTipTra ;
      A1328ConveHsPDiaDia = AV13ConveHsPDiaDia ;
      A1329ConveHsPDiaDesde = AV14ConveHsPDiaDesde ;
      n1329ConveHsPDiaDesde = false ;
      A1330ConveTarifaPDia = AV15ConveTarifaPDia ;
      A1350ConveTarifaPDRec = AV16ConveTarifaPDRec ;
      A2066ConveHsPDiaRelSec = AV17ConveHsPDiaRelSec ;
      A2432ConveTarifaPDCri = AV18ConveTarifaPDCri ;
      A2067ConveHsPdiaRelRef = "" ;
      A2068ConveHsPDiaOld = "" ;
      /* Using cursor P01XX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec), A1326ConvHsPDiaTipTra, Byte.valueOf(A1328ConveHsPDiaDia), Boolean.valueOf(n1329ConveHsPDiaDesde), A1329ConveHsPDiaDesde, A1330ConveTarifaPDia, A1350ConveTarifaPDRec, Integer.valueOf(A2066ConveHsPDiaRelSec), A2067ConveHsPdiaRelRef, A2068ConveHsPDiaOld, A2432ConveTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_horasextras_porDia");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconveniohsextpordia");
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
      A1326ConvHsPDiaTipTra = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A2432ConveTarifaPDCri = "" ;
      A2067ConveHsPdiaRelRef = "" ;
      A2068ConveHsPDiaOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconveniohsextpordia__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13ConveHsPDiaDia ;
   private byte A1328ConveHsPDiaDia ;
   private short AV9CliPaiConve ;
   private short AV11ConveHsExSec ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17ConveHsPDiaRelSec ;
   private int GX_INS215 ;
   private int A3CliCod ;
   private int A2066ConveHsPDiaRelSec ;
   private java.math.BigDecimal AV15ConveTarifaPDia ;
   private java.math.BigDecimal AV16ConveTarifaPDRec ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private String AV10CliConvenio ;
   private String AV12ConvHsPDiaTipTra ;
   private String AV14ConveHsPDiaDesde ;
   private String AV18ConveTarifaPDCri ;
   private String A1565CliConvenio ;
   private String A1326ConvHsPDiaTipTra ;
   private String A1329ConveHsPDiaDesde ;
   private String A2432ConveTarifaPDCri ;
   private String Gx_emsg ;
   private boolean n1329ConveHsPDiaDesde ;
   private String A2068ConveHsPDiaOld ;
   private String A2067ConveHsPdiaRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconveniohsextpordia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01XX2", "SAVEPOINT gxupdate;INSERT INTO Convenio_horasextras_porDia(CliCod, CliPaiConve, CliConvenio, ConveHsExSec, ConvHsPDiaTipTra, ConveHsPDiaDia, ConveHsPDiaDesde, ConveTarifaPDia, ConveTarifaPDRec, ConveHsPDiaRelSec, ConveHsPdiaRelRef, ConveHsPDiaOld, ConveTarifaPDCri, ConveHSPDiaConcepto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 5);
               }
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 4);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 4);
               stmt.setInt(10, ((Number) parms[10]).intValue());
               stmt.setVarchar(11, (String)parms[11], 40, false);
               stmt.setNLongVarchar(12, (String)parms[12], false);
               stmt.setString(13, (String)parms[13], 20);
               return;
      }
   }

}

