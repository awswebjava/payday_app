package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelvecantlic extends GXProcedure
{
   public devuelvecantlic( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelvecantlic.class ), "" );
   }

   public devuelvecantlic( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              java.util.Date aP4 ,
                              byte aP5 ,
                              short[] aP6 )
   {
      devuelvecantlic.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        byte aP5 ,
                        short[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             byte aP5 ,
                             short[] aP6 ,
                             boolean[] aP7 )
   {
      devuelvecantlic.this.AV12CliCod = aP0;
      devuelvecantlic.this.AV13EmpCod = aP1;
      devuelvecantlic.this.AV11LegNumero = aP2;
      devuelvecantlic.this.AV9LiqPeriodo = aP3;
      devuelvecantlic.this.AV10fin_periodo = aP4;
      devuelvecantlic.this.AV8LegSitCuenTrab = aP5;
      devuelvecantlic.this.aP6 = aP6;
      devuelvecantlic.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(AV8LegSitCuenTrab) ,
                                           Byte.valueOf(A1643LegSitCuenTrab) ,
                                           AV9LiqPeriodo ,
                                           AV10fin_periodo } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      /* Using cursor P025K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV11LegNumero), AV9LiqPeriodo, AV10fin_periodo, Byte.valueOf(AV8LegSitCuenTrab)});
      cV14cant = P025K2_AV14cant[0] ;
      pr_default.close(0);
      AV14cant = (short)(AV14cant+cV14cant*1) ;
      /* End optimized group. */
      if ( AV14cant > 1 )
      {
         AV15masDeUnaHay = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = devuelvecantlic.this.AV14cant;
      this.aP7[0] = devuelvecantlic.this.AV15masDeUnaHay;
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
      P025K2_AV14cant = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.devuelvecantlic__default(),
         new Object[] {
             new Object[] {
            P025K2_AV14cant
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LegSitCuenTrab ;
   private byte A1643LegSitCuenTrab ;
   private short AV13EmpCod ;
   private short AV14cant ;
   private short cV14cant ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11LegNumero ;
   private String scmdbuf ;
   private java.util.Date AV9LiqPeriodo ;
   private java.util.Date AV10fin_periodo ;
   private boolean AV15masDeUnaHay ;
   private boolean[] aP7 ;
   private short[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P025K2_AV14cant ;
}

final  class devuelvecantlic__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P025K2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV8LegSitCuenTrab ,
                                          byte A1643LegSitCuenTrab ,
                                          java.util.Date AV9LiqPeriodo ,
                                          java.util.Date AV10fin_periodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[6];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegLicenFin >= ?)");
      addWhere(sWhereString, "(LegSitEsLic = 1)");
      addWhere(sWhereString, "(LegLicEstado = ( 'autorizada'))");
      addWhere(sWhereString, "(LegLicenIni <= ?)");
      if ( ! (0==AV8LegSitCuenTrab) )
      {
         addWhere(sWhereString, "(LegSitCuenTrab = ?)");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
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
                  return conditional_P025K2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , ((Number) dynConstraints[1]).byteValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025K2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[11]).byteValue());
               }
               return;
      }
   }

}

