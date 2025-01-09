package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tieneotraliquidacionenperiodo extends GXProcedure
{
   public tieneotraliquidacionenperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tieneotraliquidacionenperiodo.class ), "" );
   }

   public tieneotraliquidacionenperiodo( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              String aP5 )
   {
      tieneotraliquidacionenperiodo.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean[] aP6 )
   {
      tieneotraliquidacionenperiodo.this.AV11CliCod = aP0;
      tieneotraliquidacionenperiodo.this.AV10EmpCod = aP1;
      tieneotraliquidacionenperiodo.this.AV9LiqNro = aP2;
      tieneotraliquidacionenperiodo.this.AV8LegNumero = aP3;
      tieneotraliquidacionenperiodo.this.AV12LiqPeriodo = aP4;
      tieneotraliquidacionenperiodo.this.AV14TLiqCod = aP5;
      tieneotraliquidacionenperiodo.this.aP6 = aP6;
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
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           AV12LiqPeriodo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A283LiqPeriodo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE
                                           }
      });
      /* Using cursor P01692 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero), AV12LiqPeriodo, Integer.valueOf(AV9LiqNro), AV14TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P01692_A32TLiqCod[0] ;
         n32TLiqCod = P01692_n32TLiqCod[0] ;
         A31LiqNro = P01692_A31LiqNro[0] ;
         A283LiqPeriodo = P01692_A283LiqPeriodo[0] ;
         A6LegNumero = P01692_A6LegNumero[0] ;
         A1EmpCod = P01692_A1EmpCod[0] ;
         A3CliCod = P01692_A3CliCod[0] ;
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
      this.aP6[0] = tieneotraliquidacionenperiodo.this.AV13tiene;
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
      P01692_A32TLiqCod = new String[] {""} ;
      P01692_n32TLiqCod = new boolean[] {false} ;
      P01692_A31LiqNro = new int[1] ;
      P01692_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01692_A6LegNumero = new int[1] ;
      P01692_A1EmpCod = new short[1] ;
      P01692_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tieneotraliquidacionenperiodo__default(),
         new Object[] {
             new Object[] {
            P01692_A32TLiqCod, P01692_n32TLiqCod, P01692_A31LiqNro, P01692_A283LiqPeriodo, P01692_A6LegNumero, P01692_A1EmpCod, P01692_A3CliCod
            }
         }
      );
      AV17Pgmname = "tieneOtraLiquidacionEnPeriodo" ;
      /* GeneXus formulas. */
      AV17Pgmname = "tieneOtraLiquidacionEnPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl2 ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int AV8LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV14TLiqCod ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV13tiene ;
   private boolean n32TLiqCod ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01692_A32TLiqCod ;
   private boolean[] P01692_n32TLiqCod ;
   private int[] P01692_A31LiqNro ;
   private java.util.Date[] P01692_A283LiqPeriodo ;
   private int[] P01692_A6LegNumero ;
   private short[] P01692_A1EmpCod ;
   private int[] P01692_A3CliCod ;
}

final  class tieneotraliquidacionenperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01692( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV14TLiqCod ,
                                          String A32TLiqCod ,
                                          int A31LiqNro ,
                                          int AV9LiqNro ,
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
      byte[] GXv_int1 = new byte[6];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT TLiqCod, LiqNro, LiqPeriodo, LegNumero, EmpCod, CliCod FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and LiqPeriodo = ?)");
      addWhere(sWhereString, "(LiqNro < ?)");
      if ( ! (GXutil.strcmp("", AV14TLiqCod)==0) )
      {
         addWhere(sWhereString, "(TLiqCod = ( ?))");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
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
                  return conditional_P01692(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (java.util.Date)dynConstraints[11] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01692", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               return;
      }
   }

}

