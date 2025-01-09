package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tieneliquidacionenperiodo extends GXProcedure
{
   public tieneliquidacionenperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tieneliquidacionenperiodo.class ), "" );
   }

   public tieneliquidacionenperiodo( int remoteHandle ,
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
      tieneliquidacionenperiodo.this.aP5 = new boolean[] {false};
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
      tieneliquidacionenperiodo.this.AV11CliCod = aP0;
      tieneliquidacionenperiodo.this.AV10EmpCod = aP1;
      tieneliquidacionenperiodo.this.AV8LegNumero = aP2;
      tieneliquidacionenperiodo.this.AV12LiqPeriodo = aP3;
      tieneliquidacionenperiodo.this.AV14TLiqCod = aP4;
      tieneliquidacionenperiodo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV8LegNumero, 8, 0))+httpContext.getMessage( " per ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV18GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV14TLiqCod ,
                                           A32TLiqCod ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           AV12LiqPeriodo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A283LiqPeriodo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.DATE
                                           }
      });
      /* Using cursor P00RR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero), AV12LiqPeriodo, AV14TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P00RR2_A32TLiqCod[0] ;
         n32TLiqCod = P00RR2_n32TLiqCod[0] ;
         A283LiqPeriodo = P00RR2_A283LiqPeriodo[0] ;
         A6LegNumero = P00RR2_A6LegNumero[0] ;
         A1EmpCod = P00RR2_A1EmpCod[0] ;
         A3CliCod = P00RR2_A3CliCod[0] ;
         A31LiqNro = P00RR2_A31LiqNro[0] ;
         AV18GXLvl2 = (byte)(1) ;
         AV13tiene = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "encuentra ", "")) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "none ", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = tieneliquidacionenperiodo.this.AV13tiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      P00RR2_A32TLiqCod = new String[] {""} ;
      P00RR2_n32TLiqCod = new boolean[] {false} ;
      P00RR2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00RR2_A6LegNumero = new int[1] ;
      P00RR2_A1EmpCod = new short[1] ;
      P00RR2_A3CliCod = new int[1] ;
      P00RR2_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tieneliquidacionenperiodo__default(),
         new Object[] {
             new Object[] {
            P00RR2_A32TLiqCod, P00RR2_n32TLiqCod, P00RR2_A283LiqPeriodo, P00RR2_A6LegNumero, P00RR2_A1EmpCod, P00RR2_A3CliCod, P00RR2_A31LiqNro
            }
         }
      );
      AV17Pgmname = "tieneLiquidacionEnPeriodo" ;
      /* GeneXus formulas. */
      AV17Pgmname = "tieneLiquidacionEnPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl2 ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private String AV14TLiqCod ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV13tiene ;
   private boolean n32TLiqCod ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00RR2_A32TLiqCod ;
   private boolean[] P00RR2_n32TLiqCod ;
   private java.util.Date[] P00RR2_A283LiqPeriodo ;
   private int[] P00RR2_A6LegNumero ;
   private short[] P00RR2_A1EmpCod ;
   private int[] P00RR2_A3CliCod ;
   private int[] P00RR2_A31LiqNro ;
}

final  class tieneliquidacionenperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00RR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV14TLiqCod ,
                                          String A32TLiqCod ,
                                          int AV11CliCod ,
                                          short AV10EmpCod ,
                                          int AV8LegNumero ,
                                          java.util.Date AV12LiqPeriodo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A283LiqPeriodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT TLiqCod, LiqPeriodo, LegNumero, EmpCod, CliCod, LiqNro FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and LiqPeriodo = ?)");
      if ( ! (GXutil.strcmp("", AV14TLiqCod)==0) )
      {
         addWhere(sWhereString, "(TLiqCod = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LiqPeriodo" ;
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
                  return conditional_P00RR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (java.util.Date)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (java.util.Date)dynConstraints[9] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

