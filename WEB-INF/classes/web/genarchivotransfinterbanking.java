package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genarchivotransfinterbanking extends GXProcedure
{
   public genarchivotransfinterbanking( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genarchivotransfinterbanking.class ), "" );
   }

   public genarchivotransfinterbanking( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             int aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      genarchivotransfinterbanking.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      genarchivotransfinterbanking.this.AV12EmpCod = aP0;
      genarchivotransfinterbanking.this.AV17LiqNro = aP1;
      genarchivotransfinterbanking.this.aP2 = aP2;
      genarchivotransfinterbanking.this.aP3 = aP3;
      genarchivotransfinterbanking.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV30CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      genarchivotransfinterbanking.this.GXt_int1 = GXv_int2[0] ;
      AV30CliCod = GXt_int1 ;
      GXt_dtime3 = AV33ahora ;
      GXv_dtime4[0] = GXt_dtime3 ;
      new web.getahora(remoteHandle, context).execute( AV30CliCod, GXv_dtime4) ;
      genarchivotransfinterbanking.this.GXt_dtime3 = GXv_dtime4[0] ;
      AV33ahora = GXt_dtime3 ;
      AV19Random = GXutil.format( "%1%2%3%4%5%6", GXutil.ltrimstr( GXutil.year( AV33ahora), 9, 0), GXutil.ltrimstr( GXutil.month( AV33ahora), 9, 0), GXutil.ltrimstr( GXutil.day( AV33ahora), 9, 0), GXutil.ltrimstr( GXutil.hour( AV33ahora), 9, 0), GXutil.ltrimstr( GXutil.minute( AV33ahora), 9, 0), GXutil.ltrimstr( GXutil.second( AV33ahora), 9, 0), "", "", "") ;
      AV18NombreArchivo = GXutil.format( httpContext.getMessage( "ArchivoInterBanking_%1_%2.txt", ""), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LiqNro), 8, 0), AV19Random, "", "", "", "", "", "", "") ;
      GXv_char5[0] = AV21rutaAplicacion ;
      new web.getdefaultpath(remoteHandle, context).execute( GXv_char5) ;
      genarchivotransfinterbanking.this.AV21rutaAplicacion = GXv_char5[0] ;
      AV29barra = "/" ;
      AV21rutaAplicacion += AV29barra + httpContext.getMessage( "TempArchivos", "") ;
      AV13folder.setSource( AV21rutaAplicacion );
      if ( ! AV13folder.exists() )
      {
         AV13folder.create();
      }
      AV9Archivo.setSource( AV21rutaAplicacion+AV29barra+AV18NombreArchivo );
      if ( AV9Archivo.exists() )
      {
         AV9Archivo.delete();
      }
      AV9Archivo.create();
      AV9Archivo.close();
      AV22SeparadorCampo = "" ;
      AV23SeparadorTexto = "" ;
      AV8Agregar = (short)(0) ;
      AV16libre = " " ;
      AV10archivoAbsolute = AV21rutaAplicacion + AV29barra + AV18NombreArchivo ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwopen( AV10archivoAbsolute, AV22SeparadorCampo, AV23SeparadorTexto, (byte)(AV8Agregar), "") ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( httpContext.getMessage( "*U*", ""), 3) ;
      AV11CBU = "??????????????????????" ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV11CBU, 22) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( httpContext.getMessage( "D", ""), 1) ;
      AV27Fecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
      AV24anio = (short)(GXutil.year( AV27Fecha)) ;
      AV25mes = (byte)(GXutil.month( AV27Fecha)) ;
      AV26dia = (byte)(GXutil.day( AV27Fecha)) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( AV24anio, 4, 0)), 4) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.padl( GXutil.str( AV25mes, 2, 0), (short)(2), "0"), 2) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.padl( GXutil.str( AV26dia, 2, 0), (short)(2), "0"), 2) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( httpContext.getMessage( "S", ""), 1) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "                                                             ", 61) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.padl( GXutil.str( AV25mes, 2, 0), (short)(7), "0"), 7) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "/", 1) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.padl( GXutil.str( AV26dia, 2, 0), (short)(2), "0"), 2) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "/", 1) ;
      AV28anioSin2000 = (short)(AV24anio-2000) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( AV28anioSin2000, 4, 0)), 2) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "             ", 13) ;
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwnext( ) ;
      new web.msgdebug(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "result 3 ", "")+GXutil.trim( GXutil.str( AV20Result, 4, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV30CliCod, 6, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV17LiqNro, 8, 0))) ;
      AV32i = (short)(0) ;
      AV37GXLvl92 = (byte)(0) ;
      /* Using cursor P005A2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV17LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P005A2_A6LegNumero[0] ;
         A234LegCBU = P005A2_A234LegCBU[0] ;
         n234LegCBU = P005A2_n234LegCBU[0] ;
         A248LegFormaPago = P005A2_A248LegFormaPago[0] ;
         A281LiqLegImpTotal = P005A2_A281LiqLegImpTotal[0] ;
         A31LiqNro = P005A2_A31LiqNro[0] ;
         A1EmpCod = P005A2_A1EmpCod[0] ;
         A3CliCod = P005A2_A3CliCod[0] ;
         A234LegCBU = P005A2_A234LegCBU[0] ;
         n234LegCBU = P005A2_n234LegCBU[0] ;
         A248LegFormaPago = P005A2_A248LegFormaPago[0] ;
         AV37GXLvl92 = (byte)(1) ;
         AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( httpContext.getMessage( "*M*", ""), 3) ;
         AV11CBU = GXutil.trim( A234LegCBU) ;
         AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV11CBU, 22) ;
         AV14Importe = (long)(DecimalUtil.decToDouble(A281LiqLegImpTotal)) ;
         AV15importeTxt = GXutil.trim( GXutil.str( AV14Importe, 17, 0)) ;
         AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.padl( AV15importeTxt, (short)(17), "0"), 17) ;
         AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "                                                            00", 62) ;
         AV20Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "                               ", 31) ;
         AV20Result = context.getSessionInstances().getDelimitedFiles().dfwnext( ) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV37GXLvl92 == 0 )
      {
         AV31error = httpContext.getMessage( "No hay legajos liquidados con forma de pago \"Banco\" o falta ingresar \"CBU\"", "") ;
      }
      if ( (GXutil.strcmp("", AV31error)==0) )
      {
         /* Optimized UPDATE. */
         /* Using cursor P005A3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV17LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* End optimized UPDATE. */
      }
      AV20Result = context.getSessionInstances().getDelimitedFiles().dfwclose( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = genarchivotransfinterbanking.this.AV10archivoAbsolute;
      this.aP3[0] = genarchivotransfinterbanking.this.AV18NombreArchivo;
      this.aP4[0] = genarchivotransfinterbanking.this.AV31error;
      Application.commitDataStores(context, remoteHandle, pr_default, "genarchivotransfinterbanking");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10archivoAbsolute = "" ;
      AV18NombreArchivo = "" ;
      AV31error = "" ;
      GXv_int2 = new int[1] ;
      AV33ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime4 = new java.util.Date[1] ;
      AV19Random = "" ;
      AV21rutaAplicacion = "" ;
      GXv_char5 = new String[1] ;
      AV29barra = "" ;
      AV13folder = new com.genexus.util.GXDirectory();
      AV9Archivo = new com.genexus.util.GXFile();
      AV22SeparadorCampo = "" ;
      AV23SeparadorTexto = "" ;
      AV16libre = "" ;
      AV11CBU = "" ;
      AV27Fecha = GXutil.nullDate() ;
      AV36Pgmname = "" ;
      scmdbuf = "" ;
      P005A2_A6LegNumero = new int[1] ;
      P005A2_A234LegCBU = new String[] {""} ;
      P005A2_n234LegCBU = new boolean[] {false} ;
      P005A2_A248LegFormaPago = new byte[1] ;
      P005A2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P005A2_A31LiqNro = new int[1] ;
      P005A2_A1EmpCod = new short[1] ;
      P005A2_A3CliCod = new int[1] ;
      A234LegCBU = "" ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      AV15importeTxt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genarchivotransfinterbanking__default(),
         new Object[] {
             new Object[] {
            P005A2_A6LegNumero, P005A2_A234LegCBU, P005A2_n234LegCBU, P005A2_A248LegFormaPago, P005A2_A281LiqLegImpTotal, P005A2_A31LiqNro, P005A2_A1EmpCod, P005A2_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      AV36Pgmname = "GenArchivoTransfInterBanking" ;
      /* GeneXus formulas. */
      AV36Pgmname = "GenArchivoTransfInterBanking" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25mes ;
   private byte AV26dia ;
   private byte AV37GXLvl92 ;
   private byte A248LegFormaPago ;
   private short AV12EmpCod ;
   private short AV8Agregar ;
   private short AV20Result ;
   private short AV24anio ;
   private short AV28anioSin2000 ;
   private short AV32i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV17LiqNro ;
   private int AV30CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private long AV14Importe ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String GXv_char5[] ;
   private String AV29barra ;
   private String AV22SeparadorCampo ;
   private String AV23SeparadorTexto ;
   private String AV16libre ;
   private String AV11CBU ;
   private String AV36Pgmname ;
   private String scmdbuf ;
   private String AV15importeTxt ;
   private java.util.Date AV33ahora ;
   private java.util.Date GXt_dtime3 ;
   private java.util.Date GXv_dtime4[] ;
   private java.util.Date AV27Fecha ;
   private boolean n234LegCBU ;
   private String AV10archivoAbsolute ;
   private String AV18NombreArchivo ;
   private String AV31error ;
   private String AV19Random ;
   private String AV21rutaAplicacion ;
   private String A234LegCBU ;
   private com.genexus.util.GXFile AV9Archivo ;
   private com.genexus.util.GXDirectory AV13folder ;
   private String[] aP4 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P005A2_A6LegNumero ;
   private String[] P005A2_A234LegCBU ;
   private boolean[] P005A2_n234LegCBU ;
   private byte[] P005A2_A248LegFormaPago ;
   private java.math.BigDecimal[] P005A2_A281LiqLegImpTotal ;
   private int[] P005A2_A31LiqNro ;
   private short[] P005A2_A1EmpCod ;
   private int[] P005A2_A3CliCod ;
}

final  class genarchivotransfinterbanking__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005A2", "SELECT T1.LegNumero, T2.LegCBU, T2.LegFormaPago, T1.LiqLegImpTotal, T1.LiqNro, T1.EmpCod, T1.CliCod FROM (LiquidacionLegajo T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ?) AND (T1.LiqLegImpTotal <> 0) AND (Not (char_length(trim(trailing ' ' from T2.LegCBU))=0)) AND (T2.LegFormaPago = 3) ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P005A3", "UPDATE Liquidacion SET LiqGenInter=TRUE  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               return;
      }
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

