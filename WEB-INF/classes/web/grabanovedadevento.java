package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabanovedadevento extends GXProcedure
{
   public grabanovedadevento( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabanovedadevento.class ), "" );
   }

   public grabanovedadevento( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 )
   {
      grabanovedadevento.this.AV8CliCod = aP0;
      grabanovedadevento.this.AV14EmpCod = aP1;
      grabanovedadevento.this.AV9LegNumero = aP2;
      grabanovedadevento.this.AV10LegLicenIni = aP3;
      grabanovedadevento.this.AV11LegLicenFin = aP4;
      grabanovedadevento.this.AV12LegLicSitCodigo = aP5;
      grabanovedadevento.this.AV13LegLicSitDescrip = aP6;
      grabanovedadevento.this.AV15LegLicDescrip = aP7;
      grabanovedadevento.this.AV16LegLicConPlus = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE LegajoLicencias

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV14EmpCod ;
      A6LegNumero = AV9LegNumero ;
      A76LegLicenIni = AV10LegLicenIni ;
      A481LegLicenFin = AV11LegLicenFin ;
      A506LegLicSitCodigo = AV12LegLicSitCodigo ;
      A517LegLicSitDescrip = AV13LegLicSitDescrip ;
      A914LegLicDescrip = AV15LegLicDescrip ;
      A1218LegLicConPlus = AV16LegLicConPlus ;
      GXv_boolean1[0] = AV18SitEsLicencia ;
      GXv_boolean2[0] = AV19sitEsAusencia ;
      GXv_boolean3[0] = AV20SitLicCuentaTrab ;
      GXv_boolean4[0] = AV21SitEsRevistaAFip ;
      GXv_boolean5[0] = false ;
      GXv_boolean6[0] = AV23EstadoCanPresen ;
      GXv_boolean7[0] = AV24EstadoRemCorr ;
      new web.getsituacionlicenciaprops(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_boolean1, GXv_boolean2, GXv_boolean3, GXv_boolean4, GXv_boolean5, GXv_boolean6, GXv_boolean7) ;
      grabanovedadevento.this.AV18SitEsLicencia = GXv_boolean1[0] ;
      grabanovedadevento.this.AV19sitEsAusencia = GXv_boolean2[0] ;
      grabanovedadevento.this.AV20SitLicCuentaTrab = GXv_boolean3[0] ;
      grabanovedadevento.this.AV21SitEsRevistaAFip = GXv_boolean4[0] ;
      grabanovedadevento.this.AV23EstadoCanPresen = GXv_boolean6[0] ;
      grabanovedadevento.this.AV24EstadoRemCorr = GXv_boolean7[0] ;
      A1287LegSitEsLic = (byte)((AV18SitEsLicencia ? 1 : 0)) ;
      A1288LegSitEsAu = (byte)((AV19sitEsAusencia ? 1 : 0)) ;
      A1289LegSitEsAfip = (byte)((AV21SitEsRevistaAFip ? 1 : 0)) ;
      A1643LegSitCuenTrab = (byte)((AV20SitLicCuentaTrab ? 1 : 0)) ;
      A1808LegLicCanPres = (byte)((AV23EstadoCanPresen ? 1 : 0)) ;
      A1810LegLicRemCorr = (byte)((AV24EstadoRemCorr ? 1 : 0)) ;
      A1497LegLicEstado = "autorizada" ;
      A1498LegLIcMot = "" ;
      A1499LegLicFile = "" ;
      A1500LegLicFileNom = "" ;
      A1501LegLicFileExt = "" ;
      /* Using cursor P015Z2 */
      A1500LegLicFileNom = com.genexus.util.GXFile.getgxFilename( A1499LegLicFile) ;
      A1501LegLicFileExt = com.genexus.util.GXFile.getgxFileext( A1499LegLicFile) ;
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni, A481LegLicenFin, A506LegLicSitCodigo, A517LegLicSitDescrip, A914LegLicDescrip, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), A1497LegLicEstado, A1498LegLIcMot, A1499LegLicFile, A1500LegLicFileNom, A1501LegLicFileExt, Byte.valueOf(A1643LegSitCuenTrab), Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
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
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      A517LegLicSitDescrip = "" ;
      A914LegLicDescrip = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      A1497LegLicEstado = "" ;
      A1498LegLIcMot = "" ;
      A1499LegLicFile = "" ;
      A1500LegLicFileNom = "" ;
      A1501LegLicFileExt = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabanovedadevento__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1287LegSitEsLic ;
   private byte A1288LegSitEsAu ;
   private byte A1289LegSitEsAfip ;
   private byte A1643LegSitCuenTrab ;
   private byte A1808LegLicCanPres ;
   private byte A1810LegLicRemCorr ;
   private short AV14EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9LegNumero ;
   private int GX_INS64 ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV12LegLicSitCodigo ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private String A1501LegLicFileExt ;
   private String Gx_emsg ;
   private java.util.Date AV10LegLicenIni ;
   private java.util.Date AV11LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private boolean AV16LegLicConPlus ;
   private boolean A1218LegLicConPlus ;
   private boolean AV18SitEsLicencia ;
   private boolean GXv_boolean1[] ;
   private boolean AV19sitEsAusencia ;
   private boolean GXv_boolean2[] ;
   private boolean AV20SitLicCuentaTrab ;
   private boolean GXv_boolean3[] ;
   private boolean AV21SitEsRevistaAFip ;
   private boolean GXv_boolean4[] ;
   private boolean GXv_boolean5[] ;
   private boolean AV23EstadoCanPresen ;
   private boolean GXv_boolean6[] ;
   private boolean AV24EstadoRemCorr ;
   private boolean GXv_boolean7[] ;
   private String A1498LegLIcMot ;
   private String A1499LegLicFile ;
   private String AV13LegLicSitDescrip ;
   private String AV15LegLicDescrip ;
   private String A517LegLicSitDescrip ;
   private String A914LegLicDescrip ;
   private String A1500LegLicFileNom ;
   private IDataStoreProvider pr_default ;
}

final  class grabanovedadevento__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P015Z2", "SAVEPOINT gxupdate;INSERT INTO LegajoLicencias(CliCod, EmpCod, LegNumero, LegLicenIni, LegLicenFin, LegLicSitCodigo, LegLicSitDescrip, LegLicDescrip, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegLicEstado, LegLIcMot, LegLicFile, LegLicFileNom, LegLicFileExt, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setString(6, (String)parms[5], 4);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setVarchar(8, (String)parms[7], 400, false);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setString(13, (String)parms[12], 20);
               stmt.setNLongVarchar(14, (String)parms[13], false);
               stmt.setBLOBFile(15, (String)parms[14]);
               stmt.setVarchar(16, (String)parms[15], 400, false);
               stmt.setString(17, (String)parms[16], 20);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               stmt.setByte(19, ((Number) parms[18]).byteValue());
               stmt.setByte(20, ((Number) parms[19]).byteValue());
               return;
      }
   }

}

