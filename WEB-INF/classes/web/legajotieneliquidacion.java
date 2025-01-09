package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajotieneliquidacion extends GXProcedure
{
   public legajotieneliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajotieneliquidacion.class ), "" );
   }

   public legajotieneliquidacion( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              String aP4 )
   {
      legajotieneliquidacion.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      legajotieneliquidacion.this.AV8CliCod = aP0;
      legajotieneliquidacion.this.AV9EmpCod = aP1;
      legajotieneliquidacion.this.AV10LegNumero = aP2;
      legajotieneliquidacion.this.AV11LiqPeriodo = aP3;
      legajotieneliquidacion.this.AV12TLiqCod = aP4;
      legajotieneliquidacion.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11LiqPeriodo ,
                                           AV12TLiqCod ,
                                           A283LiqPeriodo ,
                                           A32TLiqCod ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT
                                           }
      });
      /* Using cursor P00WE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LiqPeriodo, AV12TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P00WE2_A32TLiqCod[0] ;
         n32TLiqCod = P00WE2_n32TLiqCod[0] ;
         A283LiqPeriodo = P00WE2_A283LiqPeriodo[0] ;
         A6LegNumero = P00WE2_A6LegNumero[0] ;
         A1EmpCod = P00WE2_A1EmpCod[0] ;
         A3CliCod = P00WE2_A3CliCod[0] ;
         A31LiqNro = P00WE2_A31LiqNro[0] ;
         AV14tiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = legajotieneliquidacion.this.AV14tiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      P00WE2_A32TLiqCod = new String[] {""} ;
      P00WE2_n32TLiqCod = new boolean[] {false} ;
      P00WE2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00WE2_A6LegNumero = new int[1] ;
      P00WE2_A1EmpCod = new short[1] ;
      P00WE2_A3CliCod = new int[1] ;
      P00WE2_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajotieneliquidacion__default(),
         new Object[] {
             new Object[] {
            P00WE2_A32TLiqCod, P00WE2_n32TLiqCod, P00WE2_A283LiqPeriodo, P00WE2_A6LegNumero, P00WE2_A1EmpCod, P00WE2_A3CliCod, P00WE2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private String AV12TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV14tiene ;
   private boolean n32TLiqCod ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00WE2_A32TLiqCod ;
   private boolean[] P00WE2_n32TLiqCod ;
   private java.util.Date[] P00WE2_A283LiqPeriodo ;
   private int[] P00WE2_A6LegNumero ;
   private short[] P00WE2_A1EmpCod ;
   private int[] P00WE2_A3CliCod ;
   private int[] P00WE2_A31LiqNro ;
}

final  class legajotieneliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00WE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV11LiqPeriodo ,
                                          String AV12TLiqCod ,
                                          java.util.Date A283LiqPeriodo ,
                                          String A32TLiqCod ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT TLiqCod, LiqPeriodo, LegNumero, EmpCod, CliCod, LiqNro FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11LiqPeriodo)) )
      {
         addWhere(sWhereString, "(LiqPeriodo = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV12TLiqCod)==0) )
      {
         addWhere(sWhereString, "(TLiqCod = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero" ;
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
                  return conditional_P00WE2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (String)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00WE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[8]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
      }
   }

}

