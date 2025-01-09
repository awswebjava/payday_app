package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultimanovedad extends GXProcedure
{
   public getultimanovedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultimanovedad.class ), "" );
   }

   public getultimanovedad( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             short[] aP4 ,
                             byte[] aP5 ,
                             java.util.Date[] aP6 ,
                             boolean[] aP7 )
   {
      getultimanovedad.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        short[] aP4 ,
                        byte[] aP5 ,
                        java.util.Date[] aP6 ,
                        boolean[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             short[] aP4 ,
                             byte[] aP5 ,
                             java.util.Date[] aP6 ,
                             boolean[] aP7 ,
                             String[] aP8 )
   {
      getultimanovedad.this.AV11CliCod = aP0;
      getultimanovedad.this.AV10EmpCod = aP1;
      getultimanovedad.this.AV8LegNumero = aP2;
      getultimanovedad.this.AV9liquidadaEs = aP3;
      getultimanovedad.this.aP4 = aP4;
      getultimanovedad.this.aP5 = aP5;
      getultimanovedad.this.aP6 = aP6;
      getultimanovedad.this.aP7 = aP7;
      getultimanovedad.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19GXLvl1 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV9liquidadaEs) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02DO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02DO2_A3CliCod[0] ;
         A1EmpCod = P02DO2_A1EmpCod[0] ;
         A6LegNumero = P02DO2_A6LegNumero[0] ;
         A1254AgeLiqNro = P02DO2_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P02DO2_n1254AgeLiqNro[0] ;
         A111AgeFecDes = P02DO2_A111AgeFecDes[0] ;
         n111AgeFecDes = P02DO2_n111AgeFecDes[0] ;
         A25AgeOrden = P02DO2_A25AgeOrden[0] ;
         AV19GXLvl1 = (byte)(1) ;
         AV12novAnio = (short)(GXutil.year( A111AgeFecDes)) ;
         AV13novMes = (byte)(GXutil.month( A111AgeFecDes)) ;
         AV14novLiqPeriodo = A111AgeFecDes ;
         AV15hay = true ;
         if ( ! (0==A1254AgeLiqNro) )
         {
            GXv_char1[0] = AV16TLiqCod ;
            new web.gettipoliq(remoteHandle, context).execute( AV11CliCod, AV10EmpCod, A1254AgeLiqNro, GXv_char1) ;
            getultimanovedad.this.AV16TLiqCod = GXv_char1[0] ;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV19GXLvl1 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, httpContext.getMessage( "none ultimo nov", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getultimanovedad.this.AV12novAnio;
      this.aP5[0] = getultimanovedad.this.AV13novMes;
      this.aP6[0] = getultimanovedad.this.AV14novLiqPeriodo;
      this.aP7[0] = getultimanovedad.this.AV15hay;
      this.aP8[0] = getultimanovedad.this.AV16TLiqCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14novLiqPeriodo = GXutil.nullDate() ;
      AV16TLiqCod = "" ;
      scmdbuf = "" ;
      P02DO2_A3CliCod = new int[1] ;
      P02DO2_A1EmpCod = new short[1] ;
      P02DO2_A6LegNumero = new int[1] ;
      P02DO2_A1254AgeLiqNro = new int[1] ;
      P02DO2_n1254AgeLiqNro = new boolean[] {false} ;
      P02DO2_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P02DO2_n111AgeFecDes = new boolean[] {false} ;
      P02DO2_A25AgeOrden = new short[1] ;
      A111AgeFecDes = GXutil.nullDate() ;
      GXv_char1 = new String[1] ;
      AV20Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultimanovedad__default(),
         new Object[] {
             new Object[] {
            P02DO2_A3CliCod, P02DO2_A1EmpCod, P02DO2_A6LegNumero, P02DO2_A1254AgeLiqNro, P02DO2_n1254AgeLiqNro, P02DO2_A111AgeFecDes, P02DO2_n111AgeFecDes, P02DO2_A25AgeOrden
            }
         }
      );
      AV20Pgmname = "getUltimaNovedad" ;
      /* GeneXus formulas. */
      AV20Pgmname = "getUltimaNovedad" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13novMes ;
   private byte AV19GXLvl1 ;
   private short AV10EmpCod ;
   private short AV12novAnio ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A1254AgeLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV16TLiqCod ;
   private String scmdbuf ;
   private String GXv_char1[] ;
   private String AV20Pgmname ;
   private java.util.Date AV14novLiqPeriodo ;
   private java.util.Date A111AgeFecDes ;
   private boolean AV9liquidadaEs ;
   private boolean AV15hay ;
   private boolean n1254AgeLiqNro ;
   private boolean n111AgeFecDes ;
   private String[] aP8 ;
   private short[] aP4 ;
   private byte[] aP5 ;
   private java.util.Date[] aP6 ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P02DO2_A3CliCod ;
   private short[] P02DO2_A1EmpCod ;
   private int[] P02DO2_A6LegNumero ;
   private int[] P02DO2_A1254AgeLiqNro ;
   private boolean[] P02DO2_n1254AgeLiqNro ;
   private java.util.Date[] P02DO2_A111AgeFecDes ;
   private boolean[] P02DO2_n111AgeFecDes ;
   private short[] P02DO2_A25AgeOrden ;
}

final  class getultimanovedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02DO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV9liquidadaEs ,
                                          int A1254AgeLiqNro ,
                                          int AV11CliCod ,
                                          short AV10EmpCod ,
                                          int AV8LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[3];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegNumero, AgeLiqNro, AgeFecDes, AgeOrden FROM AgendaNovedades" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( AV9liquidadaEs )
      {
         addWhere(sWhereString, "(Not (AgeLiqNro = 0))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, AgeFecDes DESC" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
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
                  return conditional_P02DO2(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
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
      }
   }

}

