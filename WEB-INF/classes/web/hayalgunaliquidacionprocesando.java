package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayalgunaliquidacionprocesando extends GXProcedure
{
   public hayalgunaliquidacionprocesando( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayalgunaliquidacionprocesando.class ), "" );
   }

   public hayalgunaliquidacionprocesando( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             boolean[] aP4 ,
                             int[] aP5 )
   {
      hayalgunaliquidacionprocesando.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        boolean[] aP4 ,
                        int[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             boolean[] aP4 ,
                             int[] aP5 ,
                             String[] aP6 )
   {
      hayalgunaliquidacionprocesando.this.AV9CliCod = aP0;
      hayalgunaliquidacionprocesando.this.AV15EmpCod = aP1;
      hayalgunaliquidacionprocesando.this.AV11parmLiqNro = aP2;
      hayalgunaliquidacionprocesando.this.AV16LegNumero = aP3;
      hayalgunaliquidacionprocesando.this.aP4 = aP4;
      hayalgunaliquidacionprocesando.this.aP5 = aP5;
      hayalgunaliquidacionprocesando.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV14ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      hayalgunaliquidacionprocesando.this.AV14ParmValue = GXv_char1[0] ;
      AV17testEs = GXutil.boolval( AV14ParmValue) ;
      if ( ! AV17testEs )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Integer.valueOf(A6LegNumero) ,
                                              AV16LegNumero ,
                                              Integer.valueOf(AV11parmLiqNro) ,
                                              Integer.valueOf(AV16LegNumero.size()) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Byte.valueOf(A278LiqEstado) ,
                                              Boolean.valueOf(A2298LiqCancel) ,
                                              Integer.valueOf(AV9CliCod) ,
                                              Short.valueOf(AV15EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P00TQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV15EmpCod), Integer.valueOf(AV11parmLiqNro)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2298LiqCancel = P00TQ2_A2298LiqCancel[0] ;
            A6LegNumero = P00TQ2_A6LegNumero[0] ;
            A278LiqEstado = P00TQ2_A278LiqEstado[0] ;
            A31LiqNro = P00TQ2_A31LiqNro[0] ;
            A1EmpCod = P00TQ2_A1EmpCod[0] ;
            A3CliCod = P00TQ2_A3CliCod[0] ;
            A2298LiqCancel = P00TQ2_A2298LiqCancel[0] ;
            A278LiqEstado = P00TQ2_A278LiqEstado[0] ;
            AV10LiqNro = A31LiqNro ;
            AV12error = httpContext.getMessage( "Debe esperar que se termine de procesar la liquidación nro ", "") ;
            AV8hay = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( ! AV8hay )
         {
            GXv_char1[0] = AV14ParmValue ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.esperarauxiliares_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
            hayalgunaliquidacionprocesando.this.AV14ParmValue = GXv_char1[0] ;
            AV13esperarAuxiliares = GXutil.boolval( AV14ParmValue) ;
            if ( AV13esperarAuxiliares )
            {
               pr_default.dynParam(1, new Object[]{ new Object[]{
                                                    Integer.valueOf(A6LegNumero) ,
                                                    AV16LegNumero ,
                                                    Integer.valueOf(AV11parmLiqNro) ,
                                                    Integer.valueOf(AV16LegNumero.size()) ,
                                                    Integer.valueOf(A31LiqNro) ,
                                                    Byte.valueOf(A1403LiqAuxEstado) ,
                                                    Boolean.valueOf(A2298LiqCancel) ,
                                                    Integer.valueOf(AV9CliCod) ,
                                                    Short.valueOf(AV15EmpCod) ,
                                                    Integer.valueOf(A3CliCod) ,
                                                    Short.valueOf(A1EmpCod) } ,
                                                    new int[]{
                                                    TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                                    }
               });
               /* Using cursor P00TQ3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV15EmpCod), Integer.valueOf(AV11parmLiqNro)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A2298LiqCancel = P00TQ3_A2298LiqCancel[0] ;
                  A6LegNumero = P00TQ3_A6LegNumero[0] ;
                  A1403LiqAuxEstado = P00TQ3_A1403LiqAuxEstado[0] ;
                  A31LiqNro = P00TQ3_A31LiqNro[0] ;
                  A1EmpCod = P00TQ3_A1EmpCod[0] ;
                  A3CliCod = P00TQ3_A3CliCod[0] ;
                  A2298LiqCancel = P00TQ3_A2298LiqCancel[0] ;
                  A1403LiqAuxEstado = P00TQ3_A1403LiqAuxEstado[0] ;
                  AV12error = httpContext.getMessage( "Debe esperar que se termine de procesar los conceptos auxiliares de liquidación de liquidación nro ", "") ;
                  AV10LiqNro = A31LiqNro ;
                  AV8hay = true ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  pr_default.readNext(1);
               }
               pr_default.close(1);
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = hayalgunaliquidacionprocesando.this.AV8hay;
      this.aP5[0] = hayalgunaliquidacionprocesando.this.AV10LiqNro;
      this.aP6[0] = hayalgunaliquidacionprocesando.this.AV12error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12error = "" ;
      AV14ParmValue = "" ;
      scmdbuf = "" ;
      P00TQ2_A2298LiqCancel = new boolean[] {false} ;
      P00TQ2_A6LegNumero = new int[1] ;
      P00TQ2_A278LiqEstado = new byte[1] ;
      P00TQ2_A31LiqNro = new int[1] ;
      P00TQ2_A1EmpCod = new short[1] ;
      P00TQ2_A3CliCod = new int[1] ;
      GXv_char1 = new String[1] ;
      P00TQ3_A2298LiqCancel = new boolean[] {false} ;
      P00TQ3_A6LegNumero = new int[1] ;
      P00TQ3_A1403LiqAuxEstado = new byte[1] ;
      P00TQ3_A31LiqNro = new int[1] ;
      P00TQ3_A1EmpCod = new short[1] ;
      P00TQ3_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayalgunaliquidacionprocesando__default(),
         new Object[] {
             new Object[] {
            P00TQ2_A2298LiqCancel, P00TQ2_A6LegNumero, P00TQ2_A278LiqEstado, P00TQ2_A31LiqNro, P00TQ2_A1EmpCod, P00TQ2_A3CliCod
            }
            , new Object[] {
            P00TQ3_A2298LiqCancel, P00TQ3_A6LegNumero, P00TQ3_A1403LiqAuxEstado, P00TQ3_A31LiqNro, P00TQ3_A1EmpCod, P00TQ3_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A278LiqEstado ;
   private byte A1403LiqAuxEstado ;
   private short AV15EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11parmLiqNro ;
   private int AV10LiqNro ;
   private int AV16LegNumero_size ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String GXv_char1[] ;
   private boolean AV8hay ;
   private boolean AV17testEs ;
   private boolean A2298LiqCancel ;
   private boolean AV13esperarAuxiliares ;
   private String AV14ParmValue ;
   private String AV12error ;
   private GXSimpleCollection<Integer> AV16LegNumero ;
   private String[] aP6 ;
   private boolean[] aP4 ;
   private int[] aP5 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P00TQ2_A2298LiqCancel ;
   private int[] P00TQ2_A6LegNumero ;
   private byte[] P00TQ2_A278LiqEstado ;
   private int[] P00TQ2_A31LiqNro ;
   private short[] P00TQ2_A1EmpCod ;
   private int[] P00TQ2_A3CliCod ;
   private boolean[] P00TQ3_A2298LiqCancel ;
   private int[] P00TQ3_A6LegNumero ;
   private byte[] P00TQ3_A1403LiqAuxEstado ;
   private int[] P00TQ3_A31LiqNro ;
   private short[] P00TQ3_A1EmpCod ;
   private int[] P00TQ3_A3CliCod ;
}

final  class hayalgunaliquidacionprocesando__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00TQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int A6LegNumero ,
                                          GXSimpleCollection<Integer> AV16LegNumero ,
                                          int AV11parmLiqNro ,
                                          int AV16LegNumero_size ,
                                          int A31LiqNro ,
                                          byte A278LiqEstado ,
                                          boolean A2298LiqCancel ,
                                          int AV9CliCod ,
                                          short AV15EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[3];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT T2.LiqCancel, T1.LegNumero, T2.LiqEstado, T1.LiqNro, T1.EmpCod, T1.CliCod FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND" ;
      scmdbuf += " T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T2.LiqEstado = 1)");
      addWhere(sWhereString, "(T2.LiqCancel = FALSE)");
      if ( ! (0==AV11parmLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro = ?)");
      }
      else
      {
         GXv_int2[2] = (byte)(1) ;
      }
      if ( AV16LegNumero_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16LegNumero, "T1.LegNumero IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P00TQ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int A6LegNumero ,
                                          GXSimpleCollection<Integer> AV16LegNumero ,
                                          int AV11parmLiqNro ,
                                          int AV16LegNumero_size ,
                                          int A31LiqNro ,
                                          byte A1403LiqAuxEstado ,
                                          boolean A2298LiqCancel ,
                                          int AV9CliCod ,
                                          short AV15EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[3];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT T2.LiqCancel, T1.LegNumero, T2.LiqAuxEstado, T1.LiqNro, T1.EmpCod, T1.CliCod FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T2.LiqAuxEstado = 1)");
      addWhere(sWhereString, "(T2.LiqCancel = FALSE)");
      if ( ! (0==AV11parmLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro = ?)");
      }
      else
      {
         GXv_int5[2] = (byte)(1) ;
      }
      if ( AV16LegNumero_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16LegNumero, "T1.LegNumero IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P00TQ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).byteValue() , ((Boolean) dynConstraints[6]).booleanValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() );
            case 1 :
                  return conditional_P00TQ3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).byteValue() , ((Boolean) dynConstraints[6]).booleanValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00TQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00TQ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
      }
   }

}

