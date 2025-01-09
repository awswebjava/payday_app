package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerimportededucciondeperiodo extends GXProcedure
{
   public obtenerimportededucciondeperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerimportededucciondeperiodo.class ), "" );
   }

   public obtenerimportededucciondeperiodo( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              String aP4 ,
                              String aP5 ,
                              String aP6 ,
                              boolean aP7 ,
                              java.math.BigDecimal[] aP8 )
   {
      obtenerimportededucciondeperiodo.this.aP9 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        boolean[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             boolean[] aP9 )
   {
      obtenerimportededucciondeperiodo.this.AV8CliCod = aP0;
      obtenerimportededucciondeperiodo.this.AV9EmpCod = aP1;
      obtenerimportededucciondeperiodo.this.AV10LegNumero = aP2;
      obtenerimportededucciondeperiodo.this.AV11LiqPeriodo = aP3;
      obtenerimportededucciondeperiodo.this.AV12LegDedConCodigo = aP4;
      obtenerimportededucciondeperiodo.this.AV22LegDedTipo = aP5;
      obtenerimportededucciondeperiodo.this.AV14operandos = aP6;
      obtenerimportededucciondeperiodo.this.AV15validar = aP7;
      obtenerimportededucciondeperiodo.this.aP8 = aP8;
      obtenerimportededucciondeperiodo.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV11LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegDedConCodigo", "")+GXutil.trim( AV12LegDedConCodigo)) ;
      AV27GXLvl3 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV12LegDedConCodigo ,
                                           A84LegDedConCodigo ,
                                           A556LegDedFchDes ,
                                           AV11LiqPeriodo ,
                                           A557LegDedFchHas ,
                                           A1553LegDedTipo ,
                                           AV22LegDedTipo ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01012 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LiqPeriodo, AV11LiqPeriodo, AV22LegDedTipo, AV12LegDedConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1553LegDedTipo = P01012_A1553LegDedTipo[0] ;
         A84LegDedConCodigo = P01012_A84LegDedConCodigo[0] ;
         A557LegDedFchHas = P01012_A557LegDedFchHas[0] ;
         A556LegDedFchDes = P01012_A556LegDedFchDes[0] ;
         A6LegNumero = P01012_A6LegNumero[0] ;
         A1EmpCod = P01012_A1EmpCod[0] ;
         A3CliCod = P01012_A3CliCod[0] ;
         A864LegDedCodSiradig = P01012_A864LegDedCodSiradig[0] ;
         A560LegDedImporte = P01012_A560LegDedImporte[0] ;
         A83LegDedSec = P01012_A83LegDedSec[0] ;
         AV27GXLvl3 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "2") ;
         GXt_decimal1 = AV20SiraPropor ;
         GXv_decimal2[0] = GXt_decimal1 ;
         new web.getsiradigpropor(remoteHandle, context).execute( A3CliCod, "DED", GXutil.trim( GXutil.str( A864LegDedCodSiradig, 2, 0)), A84LegDedConCodigo, GXv_decimal2) ;
         obtenerimportededucciondeperiodo.this.GXt_decimal1 = GXv_decimal2[0] ;
         AV20SiraPropor = GXt_decimal1 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "2") ;
         if ( AV20SiraPropor.doubleValue() != 0 )
         {
            AV13LegDedImporte = AV13LegDedImporte.add(((A560LegDedImporte.multiply(AV20SiraPropor)))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "3") ;
         }
         else
         {
            AV13LegDedImporte = AV13LegDedImporte.add(A560LegDedImporte) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "4 "+GXutil.trim( GXutil.str( A560LegDedImporte, 14, 2))) ;
         }
         AV23existe = true ;
         if ( AV15validar )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV27GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "none 2", "")) ;
      }
      if ( AV13LegDedImporte.doubleValue() > 0 )
      {
         GXv_int3[0] = AV19LegClase ;
         new web.getlegajoclase(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_int3) ;
         obtenerimportededucciondeperiodo.this.AV19LegClase = GXv_int3[0] ;
         GXv_int3[0] = AV18primeraEs ;
         new web.esprimeraquincena(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV16LiqNro, AV10LegNumero, AV11LiqPeriodo, AV19LegClase, GXv_int3) ;
         obtenerimportededucciondeperiodo.this.AV18primeraEs = GXv_int3[0] ;
         if ( AV18primeraEs == 1 )
         {
            AV13LegDedImporte = AV13LegDedImporte.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
         }
      }
      GXv_decimal2[0] = AV17antLiqDImpCalcu ;
      new web.getliqdimpcalcu_periodoliqant(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV16LiqNro, AV10LegNumero, AV11LiqPeriodo, AV12LegDedConCodigo, false, GXv_decimal2) ;
      obtenerimportededucciondeperiodo.this.AV17antLiqDImpCalcu = GXv_decimal2[0] ;
      AV13LegDedImporte = AV13LegDedImporte.subtract(AV17antLiqDImpCalcu) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = obtenerimportededucciondeperiodo.this.AV13LegDedImporte;
      this.aP9[0] = obtenerimportededucciondeperiodo.this.AV23existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LegDedImporte = DecimalUtil.ZERO ;
      AV26Pgmname = "" ;
      scmdbuf = "" ;
      A84LegDedConCodigo = "" ;
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      A1553LegDedTipo = "" ;
      P01012_A1553LegDedTipo = new String[] {""} ;
      P01012_A84LegDedConCodigo = new String[] {""} ;
      P01012_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      P01012_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      P01012_A6LegNumero = new int[1] ;
      P01012_A1EmpCod = new short[1] ;
      P01012_A3CliCod = new int[1] ;
      P01012_A864LegDedCodSiradig = new byte[1] ;
      P01012_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01012_A83LegDedSec = new int[1] ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      AV20SiraPropor = DecimalUtil.ZERO ;
      GXt_decimal1 = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV17antLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtenerimportededucciondeperiodo__default(),
         new Object[] {
             new Object[] {
            P01012_A1553LegDedTipo, P01012_A84LegDedConCodigo, P01012_A557LegDedFchHas, P01012_A556LegDedFchDes, P01012_A6LegNumero, P01012_A1EmpCod, P01012_A3CliCod, P01012_A864LegDedCodSiradig, P01012_A560LegDedImporte, P01012_A83LegDedSec
            }
         }
      );
      AV26Pgmname = "ObtenerImporteDeduccionDePeriodo" ;
      /* GeneXus formulas. */
      AV26Pgmname = "ObtenerImporteDeduccionDePeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV27GXLvl3 ;
   private byte A864LegDedCodSiradig ;
   private byte AV19LegClase ;
   private byte AV18primeraEs ;
   private byte GXv_int3[] ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int AV16LiqNro ;
   private java.math.BigDecimal AV13LegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private java.math.BigDecimal AV20SiraPropor ;
   private java.math.BigDecimal GXt_decimal1 ;
   private java.math.BigDecimal AV17antLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV12LegDedConCodigo ;
   private String AV22LegDedTipo ;
   private String AV14operandos ;
   private String AV26Pgmname ;
   private String scmdbuf ;
   private String A84LegDedConCodigo ;
   private String A1553LegDedTipo ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date A556LegDedFchDes ;
   private java.util.Date A557LegDedFchHas ;
   private boolean AV15validar ;
   private boolean AV23existe ;
   private boolean[] aP9 ;
   private java.math.BigDecimal[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P01012_A1553LegDedTipo ;
   private String[] P01012_A84LegDedConCodigo ;
   private java.util.Date[] P01012_A557LegDedFchHas ;
   private java.util.Date[] P01012_A556LegDedFchDes ;
   private int[] P01012_A6LegNumero ;
   private short[] P01012_A1EmpCod ;
   private int[] P01012_A3CliCod ;
   private byte[] P01012_A864LegDedCodSiradig ;
   private java.math.BigDecimal[] P01012_A560LegDedImporte ;
   private int[] P01012_A83LegDedSec ;
}

final  class obtenerimportededucciondeperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01012( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12LegDedConCodigo ,
                                          String A84LegDedConCodigo ,
                                          java.util.Date A556LegDedFchDes ,
                                          java.util.Date AV11LiqPeriodo ,
                                          java.util.Date A557LegDedFchHas ,
                                          String A1553LegDedTipo ,
                                          String AV22LegDedTipo ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[7];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT LegDedTipo, LegDedConCodigo, LegDedFchHas, LegDedFchDes, LegNumero, EmpCod, CliCod, LegDedCodSiradig, LegDedImporte, LegDedSec FROM legajo_deducciones" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegDedFchDes <= ?)");
      addWhere(sWhereString, "(LegDedFchHas >= ?)");
      addWhere(sWhereString, "(LegDedTipo = ( ?))");
      if ( ! (GXutil.strcmp("", AV12LegDedConCodigo)==0) )
      {
         addWhere(sWhereString, "(LegDedConCodigo = ( ?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01012(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01012", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((int[]) buf[9])[0] = rslt.getInt(10);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
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

