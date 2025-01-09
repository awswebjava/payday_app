package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqdetimplsd_validar extends GXProcedure
{
   public liqdetimplsd_validar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqdetimplsd_validar.class ), "" );
   }

   public liqdetimplsd_validar( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      liqdetimplsd_validar.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      liqdetimplsd_validar.this.AV8CliCod = aP0;
      liqdetimplsd_validar.this.AV9EmpCod = aP1;
      liqdetimplsd_validar.this.AV15ImpLiqSec = aP2;
      liqdetimplsd_validar.this.AV16ImpLiqDetConCod = aP3;
      liqdetimplsd_validar.this.AV10ImpLiqDetCUIL = aP4;
      liqdetimplsd_validar.this.AV23ImpLiqDetPer = aP5;
      liqdetimplsd_validar.this.aP6 = aP6;
      liqdetimplsd_validar.this.aP7 = aP7;
      liqdetimplsd_validar.this.aP8 = aP8;
      liqdetimplsd_validar.this.aP9 = aP9;
      liqdetimplsd_validar.this.aP10 = aP10;
      liqdetimplsd_validar.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV11LegNumero ;
      GXv_char2[0] = AV12LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV10ImpLiqDetCUIL, "."))), GXv_int1, GXv_char2) ;
      liqdetimplsd_validar.this.AV11LegNumero = GXv_int1[0] ;
      liqdetimplsd_validar.this.AV12LegIdNomApe = GXv_char2[0] ;
      if ( (0==AV11LegNumero) )
      {
         AV13errores.add(httpContext.getMessage( "No existe legajo con CUIL ", "")+GXutil.trim( AV10ImpLiqDetCUIL)+httpContext.getMessage( " <br>", ""), 0);
      }
      else
      {
         AV14ImpLiqDetLegSis = GXutil.trim( AV12LegIdNomApe) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&ImpLiqDetConCod \"", "")+AV16ImpLiqDetConCod+"\"") ;
      AV30GXLvl10 = (byte)(0) ;
      /* Using cursor P00OH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV15ImpLiqSec), AV16ImpLiqDetConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89ImpLiqConExtCod = P00OH2_A89ImpLiqConExtCod[0] ;
         A88ImpLiqSec = P00OH2_A88ImpLiqSec[0] ;
         A1EmpCod = P00OH2_A1EmpCod[0] ;
         A3CliCod = P00OH2_A3CliCod[0] ;
         A642ImpLiqConAfipCod = P00OH2_A642ImpLiqConAfipCod[0] ;
         A641ImpLiqConSisCod = P00OH2_A641ImpLiqConSisCod[0] ;
         A702ImpLiqConSisCodYDescrip = P00OH2_A702ImpLiqConSisCodYDescrip[0] ;
         A640ImpLiqConExtDescrip = P00OH2_A640ImpLiqConExtDescrip[0] ;
         AV30GXLvl10 = (byte)(1) ;
         AV25ImpLiqConAfipCod = A642ImpLiqConAfipCod ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "ImpLiqConSisCod \"", "")+A641ImpLiqConSisCod+"\"") ;
         if ( ! (GXutil.strcmp("", A641ImpLiqConSisCod)==0) )
         {
            AV17conceptoEstaConfigurado = true ;
            AV18ImpLiqDetConSis = A641ImpLiqConSisCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&conceptoEstaConfigurado = true", "")) ;
            AV19ImpLiqDetConSisYDes = A702ImpLiqConSisCodYDescrip ;
            AV26ImpLiqConExtDescrip = A640ImpLiqConExtDescrip ;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV30GXLvl10 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "none", "")) ;
      }
      if ( ! AV17conceptoEstaConfigurado )
      {
         AV13errores.add(httpContext.getMessage( "Debe relacionar el concepto \"", "")+AV16ImpLiqDetConCod+httpContext.getMessage( "\" con un concepto del sistema. <br>", ""), 0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "agrega error", "")) ;
      }
      else
      {
         if ( ! (0==AV11LegNumero) && ! (GXutil.strcmp("", AV18ImpLiqDetConSis)==0) )
         {
            GXv_boolean3[0] = AV22hayLegLiqDet ;
            GXv_int1[0] = AV24LiqNro ;
            new web.haylegliqdet(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LegNumero, AV18ImpLiqDetConSis, AV23ImpLiqDetPer, GXv_boolean3, GXv_int1) ;
            liqdetimplsd_validar.this.AV22hayLegLiqDet = GXv_boolean3[0] ;
            liqdetimplsd_validar.this.AV24LiqNro = GXv_int1[0] ;
            if ( AV22hayLegLiqDet )
            {
               AV13errores.add(httpContext.getMessage( "Ya existe para el registro en el sistema para el legajo, periodo y concepto (Liq. Nro ", "")+GXutil.trim( GXutil.str( AV24LiqNro, 8, 0))+")", 0);
            }
         }
      }
      AV21e = (short)(1) ;
      while ( AV21e <= AV13errores.size() )
      {
         AV20ImpLiqDetError += GXutil.trim( (String)AV13errores.elementAt(-1+AV21e)) ;
         AV21e = (short)(AV21e+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = liqdetimplsd_validar.this.AV14ImpLiqDetLegSis;
      this.aP7[0] = liqdetimplsd_validar.this.AV18ImpLiqDetConSis;
      this.aP8[0] = liqdetimplsd_validar.this.AV19ImpLiqDetConSisYDes;
      this.aP9[0] = liqdetimplsd_validar.this.AV25ImpLiqConAfipCod;
      this.aP10[0] = liqdetimplsd_validar.this.AV26ImpLiqConExtDescrip;
      this.aP11[0] = liqdetimplsd_validar.this.AV20ImpLiqDetError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14ImpLiqDetLegSis = "" ;
      AV18ImpLiqDetConSis = "" ;
      AV19ImpLiqDetConSisYDes = "" ;
      AV25ImpLiqConAfipCod = "" ;
      AV26ImpLiqConExtDescrip = "" ;
      AV20ImpLiqDetError = "" ;
      AV12LegIdNomApe = "" ;
      GXv_char2 = new String[1] ;
      AV13errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29Pgmname = "" ;
      scmdbuf = "" ;
      P00OH2_A89ImpLiqConExtCod = new String[] {""} ;
      P00OH2_A88ImpLiqSec = new short[1] ;
      P00OH2_A1EmpCod = new short[1] ;
      P00OH2_A3CliCod = new int[1] ;
      P00OH2_A642ImpLiqConAfipCod = new String[] {""} ;
      P00OH2_A641ImpLiqConSisCod = new String[] {""} ;
      P00OH2_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      P00OH2_A640ImpLiqConExtDescrip = new String[] {""} ;
      A89ImpLiqConExtCod = "" ;
      A642ImpLiqConAfipCod = "" ;
      A641ImpLiqConSisCod = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A640ImpLiqConExtDescrip = "" ;
      GXv_boolean3 = new boolean[1] ;
      GXv_int1 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqdetimplsd_validar__default(),
         new Object[] {
             new Object[] {
            P00OH2_A89ImpLiqConExtCod, P00OH2_A88ImpLiqSec, P00OH2_A1EmpCod, P00OH2_A3CliCod, P00OH2_A642ImpLiqConAfipCod, P00OH2_A641ImpLiqConSisCod, P00OH2_A702ImpLiqConSisCodYDescrip, P00OH2_A640ImpLiqConExtDescrip
            }
         }
      );
      AV29Pgmname = "LiqDetImpLSD_Validar" ;
      /* GeneXus formulas. */
      AV29Pgmname = "LiqDetImpLSD_Validar" ;
      Gx_err = (short)(0) ;
   }

   private byte AV30GXLvl10 ;
   private short AV9EmpCod ;
   private short AV15ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV21e ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int AV24LiqNro ;
   private int GXv_int1[] ;
   private String AV16ImpLiqDetConCod ;
   private String AV10ImpLiqDetCUIL ;
   private String AV23ImpLiqDetPer ;
   private String AV18ImpLiqDetConSis ;
   private String AV25ImpLiqConAfipCod ;
   private String GXv_char2[] ;
   private String AV29Pgmname ;
   private String scmdbuf ;
   private String A89ImpLiqConExtCod ;
   private String A642ImpLiqConAfipCod ;
   private String A641ImpLiqConSisCod ;
   private boolean AV17conceptoEstaConfigurado ;
   private boolean AV22hayLegLiqDet ;
   private boolean GXv_boolean3[] ;
   private String AV14ImpLiqDetLegSis ;
   private String AV19ImpLiqDetConSisYDes ;
   private String AV26ImpLiqConExtDescrip ;
   private String AV20ImpLiqDetError ;
   private String AV12LegIdNomApe ;
   private String A702ImpLiqConSisCodYDescrip ;
   private String A640ImpLiqConExtDescrip ;
   private String[] aP11 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private String[] P00OH2_A89ImpLiqConExtCod ;
   private short[] P00OH2_A88ImpLiqSec ;
   private short[] P00OH2_A1EmpCod ;
   private int[] P00OH2_A3CliCod ;
   private String[] P00OH2_A642ImpLiqConAfipCod ;
   private String[] P00OH2_A641ImpLiqConSisCod ;
   private String[] P00OH2_A702ImpLiqConSisCodYDescrip ;
   private String[] P00OH2_A640ImpLiqConExtDescrip ;
   private GXSimpleCollection<String> AV13errores ;
}

final  class liqdetimplsd_validar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OH2", "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod, ImpLiqConAfipCod, ImpLiqConSisCod, ImpLiqConSisCodYDescrip, ImpLiqConExtDescrip FROM importacion_conceptos WHERE (CliCod = ? and EmpCod = ? and ImpLiqSec = ?) AND (RTRIM(LTRIM(UPPER(ImpLiqConExtCod))) = ( RTRIM(LTRIM(UPPER(?))))) ORDER BY CliCod, EmpCod, ImpLiqSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
      }
   }

}

