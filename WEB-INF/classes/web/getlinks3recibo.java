package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlinks3recibo extends GXProcedure
{
   public getlinks3recibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlinks3recibo.class ), "" );
   }

   public getlinks3recibo( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      getlinks3recibo.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      getlinks3recibo.this.AV8CliCod = aP0;
      getlinks3recibo.this.AV9EmpCod = aP1;
      getlinks3recibo.this.AV12LiqNro = aP2;
      getlinks3recibo.this.AV11LegNumero = aP3;
      getlinks3recibo.this.AV13tipoRecibo = aP4;
      getlinks3recibo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV12LiqNro, 8, 0))+httpContext.getMessage( " legnum ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
      AV17GXLvl17 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV13tipoRecibo ,
                                           A2277LegLinkTiporec ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV12LiqNro) ,
                                           Integer.valueOf(AV11LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A2285LinkLegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P029Z2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV12LiqNro), Integer.valueOf(AV11LegNumero), AV13tipoRecibo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2277LegLinkTiporec = P029Z2_A2277LegLinkTiporec[0] ;
         A2285LinkLegNumero = P029Z2_A2285LinkLegNumero[0] ;
         A31LiqNro = P029Z2_A31LiqNro[0] ;
         A1EmpCod = P029Z2_A1EmpCod[0] ;
         A3CliCod = P029Z2_A3CliCod[0] ;
         A2278LegLinkS3Html = P029Z2_A2278LegLinkS3Html[0] ;
         AV17GXLvl17 = (byte)(1) ;
         AV10LegLinkS3Html = A2278LegLinkS3Html ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV17GXLvl17 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlinks3recibo.this.AV10LegLinkS3Html;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LegLinkS3Html = "" ;
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      A2277LegLinkTiporec = "" ;
      P029Z2_A2277LegLinkTiporec = new String[] {""} ;
      P029Z2_A2285LinkLegNumero = new int[1] ;
      P029Z2_A31LiqNro = new int[1] ;
      P029Z2_A1EmpCod = new short[1] ;
      P029Z2_A3CliCod = new int[1] ;
      P029Z2_A2278LegLinkS3Html = new String[] {""} ;
      A2278LegLinkS3Html = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlinks3recibo__default(),
         new Object[] {
             new Object[] {
            P029Z2_A2277LegLinkTiporec, P029Z2_A2285LinkLegNumero, P029Z2_A31LiqNro, P029Z2_A1EmpCod, P029Z2_A3CliCod, P029Z2_A2278LegLinkS3Html
            }
         }
      );
      AV16Pgmname = "getLinkS3Recibo" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getLinkS3Recibo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl17 ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV12LiqNro ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A2285LinkLegNumero ;
   private String AV13tipoRecibo ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A2277LegLinkTiporec ;
   private String AV10LegLinkS3Html ;
   private String A2278LegLinkS3Html ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P029Z2_A2277LegLinkTiporec ;
   private int[] P029Z2_A2285LinkLegNumero ;
   private int[] P029Z2_A31LiqNro ;
   private short[] P029Z2_A1EmpCod ;
   private int[] P029Z2_A3CliCod ;
   private String[] P029Z2_A2278LegLinkS3Html ;
}

final  class getlinks3recibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P029Z2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13tipoRecibo ,
                                          String A2277LegLinkTiporec ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV12LiqNro ,
                                          int AV11LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A2285LinkLegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegLinkTiporec, LinkLegNumero, LiqNro, EmpCod, CliCod, LegLinkS3Html FROM LiquidacionLegajoLinkPdf" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LinkLegNumero = ?)");
      if ( ! (GXutil.strcmp("", AV13tipoRecibo)==0) )
      {
         addWhere(sWhereString, "(LegLinkTiporec = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LinkLegNumero" ;
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
                  return conditional_P029Z2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P029Z2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
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

