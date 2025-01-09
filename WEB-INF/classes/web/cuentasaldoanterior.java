package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cuentasaldoanterior extends GXProcedure
{
   public cuentasaldoanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cuentasaldoanterior.class ), "" );
   }

   public cuentasaldoanterior( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 ,
                              int aP3 ,
                              String aP4 ,
                              int aP5 ,
                              boolean aP6 ,
                              java.math.BigDecimal[] aP7 )
   {
      cuentasaldoanterior.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        String aP4 ,
                        int aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             boolean[] aP8 )
   {
      cuentasaldoanterior.this.AV9CliCod = aP0;
      cuentasaldoanterior.this.AV10EmpCod = aP1;
      cuentasaldoanterior.this.AV11LiqLegConAnio = aP2;
      cuentasaldoanterior.this.AV12LegNumero = aP3;
      cuentasaldoanterior.this.AV13ConCodigo = aP4;
      cuentasaldoanterior.this.AV14LiqNro = aP5;
      cuentasaldoanterior.this.AV17LiqLegEsPrrGan = aP6;
      cuentasaldoanterior.this.aP7 = aP7;
      cuentasaldoanterior.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV13ConCodigo ,
                                           A26ConCodigo ,
                                           Integer.valueOf(A1098LiqNuevaNro) ,
                                           Integer.valueOf(AV14LiqNro) ,
                                           Boolean.valueOf(A1778LiqLegEsPrrGan) ,
                                           Boolean.valueOf(AV17LiqLegEsPrrGan) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Short.valueOf(AV11LiqLegConAnio) ,
                                           Integer.valueOf(AV12LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(A869LiqLegConAnio) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01LV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Short.valueOf(AV11LiqLegConAnio), Integer.valueOf(AV12LegNumero), Integer.valueOf(AV14LiqNro), Boolean.valueOf(AV17LiqLegEsPrrGan), AV13ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01LV2_A3CliCod[0] ;
         A1EmpCod = P01LV2_A1EmpCod[0] ;
         A869LiqLegConAnio = P01LV2_A869LiqLegConAnio[0] ;
         A6LegNumero = P01LV2_A6LegNumero[0] ;
         A1778LiqLegEsPrrGan = P01LV2_A1778LiqLegEsPrrGan[0] ;
         A1098LiqNuevaNro = P01LV2_A1098LiqNuevaNro[0] ;
         A26ConCodigo = P01LV2_A26ConCodigo[0] ;
         A868LiqLegConSaldo = P01LV2_A868LiqLegConSaldo[0] ;
         A1097LiqAltaNro = P01LV2_A1097LiqAltaNro[0] ;
         AV8LiqLegConSaldo = A868LiqLegConSaldo ;
         AV16existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = cuentasaldoanterior.this.AV8LiqLegConSaldo;
      this.aP8[0] = cuentasaldoanterior.this.AV16existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LiqLegConSaldo = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      A26ConCodigo = "" ;
      P01LV2_A3CliCod = new int[1] ;
      P01LV2_A1EmpCod = new short[1] ;
      P01LV2_A869LiqLegConAnio = new short[1] ;
      P01LV2_A6LegNumero = new int[1] ;
      P01LV2_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      P01LV2_A1098LiqNuevaNro = new int[1] ;
      P01LV2_A26ConCodigo = new String[] {""} ;
      P01LV2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LV2_A1097LiqAltaNro = new int[1] ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cuentasaldoanterior__default(),
         new Object[] {
             new Object[] {
            P01LV2_A3CliCod, P01LV2_A1EmpCod, P01LV2_A869LiqLegConAnio, P01LV2_A6LegNumero, P01LV2_A1778LiqLegEsPrrGan, P01LV2_A1098LiqNuevaNro, P01LV2_A26ConCodigo, P01LV2_A868LiqLegConSaldo, P01LV2_A1097LiqAltaNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV11LiqLegConAnio ;
   private short A1EmpCod ;
   private short A869LiqLegConAnio ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV12LegNumero ;
   private int AV14LiqNro ;
   private int A1098LiqNuevaNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A1097LiqAltaNro ;
   private java.math.BigDecimal AV8LiqLegConSaldo ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private String AV13ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV17LiqLegEsPrrGan ;
   private boolean AV16existe ;
   private boolean A1778LiqLegEsPrrGan ;
   private boolean[] aP8 ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P01LV2_A3CliCod ;
   private short[] P01LV2_A1EmpCod ;
   private short[] P01LV2_A869LiqLegConAnio ;
   private int[] P01LV2_A6LegNumero ;
   private boolean[] P01LV2_A1778LiqLegEsPrrGan ;
   private int[] P01LV2_A1098LiqNuevaNro ;
   private String[] P01LV2_A26ConCodigo ;
   private java.math.BigDecimal[] P01LV2_A868LiqLegConSaldo ;
   private int[] P01LV2_A1097LiqAltaNro ;
}

final  class cuentasaldoanterior__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01LV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13ConCodigo ,
                                          String A26ConCodigo ,
                                          int A1098LiqNuevaNro ,
                                          int AV14LiqNro ,
                                          boolean A1778LiqLegEsPrrGan ,
                                          boolean AV17LiqLegEsPrrGan ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          short AV11LiqLegConAnio ,
                                          int AV12LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          short A869LiqLegConAnio ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[7];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, LiqLegEsPrrGan, LiqNuevaNro, ConCodigo, LiqLegConSaldo, LiqAltaNro FROM LiqLegConceptoCuenta" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LiqNuevaNro < ?)");
      addWhere(sWhereString, "(LiqLegEsPrrGan = ?)");
      if ( ! (GXutil.strcmp("", AV13ConCodigo)==0) )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int1[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqNuevaNro DESC" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01LV2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Boolean) dynConstraints[4]).booleanValue() , ((Boolean) dynConstraints[5]).booleanValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBoolean(sIdx, ((Boolean) parms[12]).booleanValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               return;
      }
   }

}

