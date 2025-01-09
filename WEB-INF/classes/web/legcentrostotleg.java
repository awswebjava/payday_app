package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legcentrostotleg extends GXProcedure
{
   public legcentrostotleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legcentrostotleg.class ), "" );
   }

   public legcentrostotleg( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 ,
                                           int aP1 ,
                                           short aP2 ,
                                           int aP3 )
   {
      legcentrostotleg.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        short aP2 ,
                        int aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             short aP2 ,
                             int aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      legcentrostotleg.this.AV14CenCodigo = aP0;
      legcentrostotleg.this.AV10clicod = aP1;
      legcentrostotleg.this.AV9empcod = aP2;
      legcentrostotleg.this.AV8legnumero = aP3;
      legcentrostotleg.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV14CenCodigo) ,
                                           Short.valueOf(A77CenCodigo) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00H92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV8legnumero), Short.valueOf(AV14CenCodigo)});
      c484LegCenPrc = P00H92_A484LegCenPrc[0] ;
      pr_default.close(0);
      AV11LegCenPrc = AV11LegCenPrc.add(c484LegCenPrc) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = legcentrostotleg.this.AV11LegCenPrc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LegCenPrc = DecimalUtil.ZERO ;
      c484LegCenPrc = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00H92_A484LegCenPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legcentrostotleg__default(),
         new Object[] {
             new Object[] {
            P00H92_A484LegCenPrc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14CenCodigo ;
   private short AV9empcod ;
   private short A77CenCodigo ;
   private short Gx_err ;
   private int AV10clicod ;
   private int AV8legnumero ;
   private java.math.BigDecimal AV11LegCenPrc ;
   private java.math.BigDecimal c484LegCenPrc ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00H92_A484LegCenPrc ;
}

final  class legcentrostotleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00H92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV14CenCodigo ,
                                          short A77CenCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT SUM(LegCenPrc) FROM LegajoCC" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! (0==AV14CenCodigo) )
      {
         addWhere(sWhereString, "(CenCodigo <> ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
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
                  return conditional_P00H92(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00H92", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
      }
   }

}

