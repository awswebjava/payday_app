package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class asistencia_perfecta extends GXProcedure
{
   public asistencia_perfecta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( asistencia_perfecta.class ), "" );
   }

   public asistencia_perfecta( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short[] aP5 )
   {
      asistencia_perfecta.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short[] aP5 ,
                             String[] aP6 )
   {
      asistencia_perfecta.this.AV9CliCod = aP0;
      asistencia_perfecta.this.AV10EmpCod = aP1;
      asistencia_perfecta.this.AV13LiqNro = aP2;
      asistencia_perfecta.this.AV11LegNumero = aP3;
      asistencia_perfecta.this.AV15LiqPeriodo = aP4;
      asistencia_perfecta.this.aP5 = aP5;
      asistencia_perfecta.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8asistencia_perfecta = (short)(1) ;
      GXv_char1[0] = AV23ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_char1) ;
      asistencia_perfecta.this.AV23ConveCodigo = GXv_char1[0] ;
      GXv_int2[0] = AV14LegClase ;
      GXv_char1[0] = AV37LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_int2, GXv_char1) ;
      asistencia_perfecta.this.AV14LegClase = GXv_int2[0] ;
      asistencia_perfecta.this.AV37LegModTra = GXv_char1[0] ;
      GXv_char1[0] = AV38tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV13LiqNro, AV11LegNumero, (short)(0), "", "", GXv_char1) ;
      asistencia_perfecta.this.AV38tipo_tarifa = GXv_char1[0] ;
      GXv_char1[0] = AV12TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV13LiqNro, GXv_char1) ;
      asistencia_perfecta.this.AV12TLiqCod = GXv_char1[0] ;
      GXv_boolean3[0] = AV32trabajadoHay ;
      new web.haytrabajado(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, AV13LiqNro, AV15LiqPeriodo, AV14LegClase, AV38tipo_tarifa, AV12TLiqCod, GXv_boolean3) ;
      asistencia_perfecta.this.AV32trabajadoHay = GXv_boolean3[0] ;
      if ( ! AV32trabajadoHay )
      {
         if ( GXutil.strcmp(AV38tipo_tarifa, "H") == 0 )
         {
            AV33liqdlog = httpContext.getMessage( "No se registraron horas trabajadas", "") ;
         }
         else
         {
            AV33liqdlog = httpContext.getMessage( "Cantidad de dìas de licencia es igual a cantidad de días del mes", "") ;
         }
         AV8asistencia_perfecta = (short)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_date4[0] = AV16primerDiaPeriodo ;
      GXv_date5[0] = AV17ultimoDiaPeriodo ;
      new web.getrangoperiodos(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV13LiqNro, AV11LegNumero, AV12TLiqCod, AV14LegClase, AV15LiqPeriodo, false, GXv_date4, GXv_date5) ;
      asistencia_perfecta.this.AV16primerDiaPeriodo = GXv_date4[0] ;
      asistencia_perfecta.this.AV17ultimoDiaPeriodo = GXv_date5[0] ;
      if ( ! (GXutil.strcmp("", AV23ConveCodigo)==0) )
      {
         GXv_int6[0] = AV25CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_int6) ;
         asistencia_perfecta.this.AV25CliConveVer = GXv_int6[0] ;
         GXv_int7[0] = AV26PaiCod ;
         new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int7) ;
         asistencia_perfecta.this.AV26PaiCod = GXv_int7[0] ;
         GXt_char8 = AV34ConveAdicod ;
         GXv_char1[0] = GXt_char8 ;
         new web.getadicionalreservado(remoteHandle, context).execute( AV26PaiCod, "presentismo", GXv_char1) ;
         asistencia_perfecta.this.GXt_char8 = GXv_char1[0] ;
         AV34ConveAdicod = GXt_char8 ;
         GXv_boolean3[0] = AV36seCancela ;
         GXv_char1[0] = AV35auxLiqDLog ;
         new web.getestadocancelaadicional(remoteHandle, context).execute( AV9CliCod, AV25CliConveVer, AV10EmpCod, AV11LegNumero, AV26PaiCod, AV34ConveAdicod, AV34ConveAdicod, AV16primerDiaPeriodo, AV17ultimoDiaPeriodo, GXv_boolean3, GXv_char1) ;
         asistencia_perfecta.this.AV36seCancela = GXv_boolean3[0] ;
         asistencia_perfecta.this.AV35auxLiqDLog = GXv_char1[0] ;
         if ( AV36seCancela )
         {
            AV8asistencia_perfecta = (short)(0) ;
            AV33liqdlog = AV35auxLiqDLog ;
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, "<= "+GXutil.trim( localUtil.dtoc( AV17ultimoDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, ">= "+GXutil.trim( localUtil.dtoc( AV16primerDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         AV43GXLvl48 = (byte)(0) ;
         /* Using cursor P018S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV16primerDiaPeriodo, AV17ultimoDiaPeriodo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1808LegLicCanPres = P018S2_A1808LegLicCanPres[0] ;
            A1497LegLicEstado = P018S2_A1497LegLicEstado[0] ;
            A481LegLicenFin = P018S2_A481LegLicenFin[0] ;
            A76LegLicenIni = P018S2_A76LegLicenIni[0] ;
            A6LegNumero = P018S2_A6LegNumero[0] ;
            A1EmpCod = P018S2_A1EmpCod[0] ;
            A3CliCod = P018S2_A3CliCod[0] ;
            A517LegLicSitDescrip = P018S2_A517LegLicSitDescrip[0] ;
            AV43GXLvl48 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "encuentra", "")) ;
            AV8asistencia_perfecta = (short)(0) ;
            AV33liqdlog = httpContext.getMessage( "La licencia \"", "") + GXutil.trim( A517LegLicSitDescrip) + httpContext.getMessage( "\" del ", "") + GXutil.trim( localUtil.dtoc( A76LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " cancela el presentismo", "") ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV43GXLvl48 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = asistencia_perfecta.this.AV8asistencia_perfecta;
      this.aP6[0] = asistencia_perfecta.this.AV33liqdlog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33liqdlog = "" ;
      AV23ConveCodigo = "" ;
      GXv_int2 = new byte[1] ;
      AV37LegModTra = "" ;
      AV38tipo_tarifa = "" ;
      AV12TLiqCod = "" ;
      AV16primerDiaPeriodo = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      AV17ultimoDiaPeriodo = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_int6 = new int[1] ;
      GXv_int7 = new short[1] ;
      AV34ConveAdicod = "" ;
      GXt_char8 = "" ;
      GXv_boolean3 = new boolean[1] ;
      AV35auxLiqDLog = "" ;
      GXv_char1 = new String[1] ;
      AV42Pgmname = "" ;
      scmdbuf = "" ;
      P018S2_A1808LegLicCanPres = new byte[1] ;
      P018S2_A1497LegLicEstado = new String[] {""} ;
      P018S2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P018S2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P018S2_A6LegNumero = new int[1] ;
      P018S2_A1EmpCod = new short[1] ;
      P018S2_A3CliCod = new int[1] ;
      P018S2_A517LegLicSitDescrip = new String[] {""} ;
      A1497LegLicEstado = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      A517LegLicSitDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.asistencia_perfecta__default(),
         new Object[] {
             new Object[] {
            P018S2_A1808LegLicCanPres, P018S2_A1497LegLicEstado, P018S2_A481LegLicenFin, P018S2_A76LegLicenIni, P018S2_A6LegNumero, P018S2_A1EmpCod, P018S2_A3CliCod, P018S2_A517LegLicSitDescrip
            }
         }
      );
      AV42Pgmname = "asistencia_perfecta" ;
      /* GeneXus formulas. */
      AV42Pgmname = "asistencia_perfecta" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14LegClase ;
   private byte GXv_int2[] ;
   private byte AV43GXLvl48 ;
   private byte A1808LegLicCanPres ;
   private short AV10EmpCod ;
   private short AV8asistencia_perfecta ;
   private short AV26PaiCod ;
   private short GXv_int7[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV13LiqNro ;
   private int AV11LegNumero ;
   private int AV25CliConveVer ;
   private int GXv_int6[] ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV23ConveCodigo ;
   private String AV37LegModTra ;
   private String AV38tipo_tarifa ;
   private String AV12TLiqCod ;
   private String AV34ConveAdicod ;
   private String GXt_char8 ;
   private String GXv_char1[] ;
   private String AV42Pgmname ;
   private String scmdbuf ;
   private String A1497LegLicEstado ;
   private java.util.Date AV15LiqPeriodo ;
   private java.util.Date AV16primerDiaPeriodo ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date AV17ultimoDiaPeriodo ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV32trabajadoHay ;
   private boolean returnInSub ;
   private boolean AV36seCancela ;
   private boolean GXv_boolean3[] ;
   private String AV33liqdlog ;
   private String AV35auxLiqDLog ;
   private String A517LegLicSitDescrip ;
   private String[] aP6 ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private byte[] P018S2_A1808LegLicCanPres ;
   private String[] P018S2_A1497LegLicEstado ;
   private java.util.Date[] P018S2_A481LegLicenFin ;
   private java.util.Date[] P018S2_A76LegLicenIni ;
   private int[] P018S2_A6LegNumero ;
   private short[] P018S2_A1EmpCod ;
   private int[] P018S2_A3CliCod ;
   private String[] P018S2_A517LegLicSitDescrip ;
}

final  class asistencia_perfecta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018S2", "SELECT LegLicCanPres, LegLicEstado, LegLicenFin, LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitDescrip FROM LegajoLicencias WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegLicenFin >= ?) AND (LegLicEstado = ( 'autorizada')) AND (LegLicCanPres = 1) AND (LegLicenIni <= ?) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

