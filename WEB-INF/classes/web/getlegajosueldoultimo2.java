package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajosueldoultimo2 extends GXProcedure
{
   public getlegajosueldoultimo2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajosueldoultimo2.class ), "" );
   }

   public getlegajosueldoultimo2( int remoteHandle ,
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
                              java.math.BigDecimal[] aP5 ,
                              String[] aP6 )
   {
      getlegajosueldoultimo2.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             boolean[] aP7 )
   {
      getlegajosueldoultimo2.this.AV8CliCod = aP0;
      getlegajosueldoultimo2.this.AV9EmpCod = aP1;
      getlegajosueldoultimo2.this.AV10LegNumero = aP2;
      getlegajosueldoultimo2.this.AV11LegSuelFecha = aP3;
      getlegajosueldoultimo2.this.AV13que = aP4;
      getlegajosueldoultimo2.this.aP5 = aP5;
      getlegajosueldoultimo2.this.aP6 = aP6;
      getlegajosueldoultimo2.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11LegSuelFecha ,
                                           A1136LegSuelFecha ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02EF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegSuelFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1136LegSuelFecha = P02EF2_A1136LegSuelFecha[0] ;
         A6LegNumero = P02EF2_A6LegNumero[0] ;
         A1EmpCod = P02EF2_A1EmpCod[0] ;
         A3CliCod = P02EF2_A3CliCod[0] ;
         A2344LegSuelTipo = P02EF2_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = P02EF2_n2344LegSuelTipo[0] ;
         A1137LegSuelImporte = P02EF2_A1137LegSuelImporte[0] ;
         A2347LegSuelCalc = P02EF2_A2347LegSuelCalc[0] ;
         A1135LegSuelSec = P02EF2_A1135LegSuelSec[0] ;
         if ( GXutil.strcmp(AV13que, httpContext.getMessage( "Bruto", "")) == 0 )
         {
            if ( GXutil.strcmp(A2344LegSuelTipo, "Bruto") == 0 )
            {
               AV12LegSuelImporte = A1137LegSuelImporte ;
            }
            else
            {
               AV12LegSuelImporte = A2347LegSuelCalc ;
            }
         }
         else
         {
            if ( GXutil.strcmp(A2344LegSuelTipo, "Bruto") == 0 )
            {
               AV12LegSuelImporte = A2347LegSuelCalc ;
            }
            else
            {
               AV12LegSuelImporte = A1137LegSuelImporte ;
            }
         }
         AV15LegSuelTipo = A2344LegSuelTipo ;
         AV14existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlegajosueldoultimo2.this.AV12LegSuelImporte;
      this.aP6[0] = getlegajosueldoultimo2.this.AV15LegSuelTipo;
      this.aP7[0] = getlegajosueldoultimo2.this.AV14existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegSuelImporte = DecimalUtil.ZERO ;
      AV15LegSuelTipo = "" ;
      scmdbuf = "" ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      P02EF2_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P02EF2_A6LegNumero = new int[1] ;
      P02EF2_A1EmpCod = new short[1] ;
      P02EF2_A3CliCod = new int[1] ;
      P02EF2_A2344LegSuelTipo = new String[] {""} ;
      P02EF2_n2344LegSuelTipo = new boolean[] {false} ;
      P02EF2_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02EF2_A2347LegSuelCalc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02EF2_A1135LegSuelSec = new short[1] ;
      A2344LegSuelTipo = "" ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      A2347LegSuelCalc = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajosueldoultimo2__default(),
         new Object[] {
             new Object[] {
            P02EF2_A1136LegSuelFecha, P02EF2_A6LegNumero, P02EF2_A1EmpCod, P02EF2_A3CliCod, P02EF2_A2344LegSuelTipo, P02EF2_n2344LegSuelTipo, P02EF2_A1137LegSuelImporte, P02EF2_A2347LegSuelCalc, P02EF2_A1135LegSuelSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV12LegSuelImporte ;
   private java.math.BigDecimal A1137LegSuelImporte ;
   private java.math.BigDecimal A2347LegSuelCalc ;
   private String AV13que ;
   private String AV15LegSuelTipo ;
   private String scmdbuf ;
   private String A2344LegSuelTipo ;
   private java.util.Date AV11LegSuelFecha ;
   private java.util.Date A1136LegSuelFecha ;
   private boolean AV14existe ;
   private boolean n2344LegSuelTipo ;
   private boolean[] aP7 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02EF2_A1136LegSuelFecha ;
   private int[] P02EF2_A6LegNumero ;
   private short[] P02EF2_A1EmpCod ;
   private int[] P02EF2_A3CliCod ;
   private String[] P02EF2_A2344LegSuelTipo ;
   private boolean[] P02EF2_n2344LegSuelTipo ;
   private java.math.BigDecimal[] P02EF2_A1137LegSuelImporte ;
   private java.math.BigDecimal[] P02EF2_A2347LegSuelCalc ;
   private short[] P02EF2_A1135LegSuelSec ;
}

final  class getlegajosueldoultimo2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02EF2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV11LegSuelFecha ,
                                          java.util.Date A1136LegSuelFecha ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegSuelFecha, LegNumero, EmpCod, CliCod, LegSuelTipo, LegSuelImporte, LegSuelCalc, LegSuelSec FROM legajo_sueldos" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11LegSuelFecha)) )
      {
         addWhere(sWhereString, "(LegSuelFecha <= ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegSuelFecha DESC" ;
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
                  return conditional_P02EF2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EF2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((short[]) buf[8])[0] = rslt.getShort(8);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
      }
   }

}

