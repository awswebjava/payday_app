package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class resetearecibos extends GXProcedure
{
   public resetearecibos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( resetearecibos.class ), "" );
   }

   public resetearecibos( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 )
   {
      resetearecibos.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 )
   {
      resetearecibos.this.AV9CliCod = aP0;
      resetearecibos.this.AV10EmpCod = aP1;
      resetearecibos.this.AV11LiqNro = aP2;
      resetearecibos.this.AV8LegNumero = aP3;
      resetearecibos.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV11LiqNro, 8, 0))+httpContext.getMessage( " legnum ", "")+GXutil.trim( GXutil.str( AV8LegNumero, 8, 0))) ;
      AV18GXLvl15 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV11LiqNro) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A2285LinkLegNumero) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P025G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2285LinkLegNumero = P025G2_A2285LinkLegNumero[0] ;
         A31LiqNro = P025G2_A31LiqNro[0] ;
         A1EmpCod = P025G2_A1EmpCod[0] ;
         A3CliCod = P025G2_A3CliCod[0] ;
         A2278LegLinkS3Html = P025G2_A2278LegLinkS3Html[0] ;
         A2277LegLinkTiporec = P025G2_A2277LegLinkTiporec[0] ;
         AV18GXLvl15 = (byte)(1) ;
         /* Using cursor P025G3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A2285LinkLegNumero), A2277LegLinkTiporec});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajoLinkPdf");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18GXLvl15 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "none ", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = resetearecibos.this.AV14error;
      Application.commitDataStores(context, remoteHandle, pr_default, "resetearecibos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P025G2_A2285LinkLegNumero = new int[1] ;
      P025G2_A31LiqNro = new int[1] ;
      P025G2_A1EmpCod = new short[1] ;
      P025G2_A3CliCod = new int[1] ;
      P025G2_A2278LegLinkS3Html = new String[] {""} ;
      P025G2_A2277LegLinkTiporec = new String[] {""} ;
      A2278LegLinkS3Html = "" ;
      A2277LegLinkTiporec = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.resetearecibos__default(),
         new Object[] {
             new Object[] {
            P025G2_A2285LinkLegNumero, P025G2_A31LiqNro, P025G2_A1EmpCod, P025G2_A3CliCod, P025G2_A2278LegLinkS3Html, P025G2_A2277LegLinkTiporec
            }
            , new Object[] {
            }
         }
      );
      AV17Pgmname = "reseteaRecibos" ;
      /* GeneXus formulas. */
      AV17Pgmname = "reseteaRecibos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl15 ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV8LegNumero ;
   private int A31LiqNro ;
   private int A2285LinkLegNumero ;
   private int A3CliCod ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A2277LegLinkTiporec ;
   private String AV14error ;
   private String A2278LegLinkS3Html ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P025G2_A2285LinkLegNumero ;
   private int[] P025G2_A31LiqNro ;
   private short[] P025G2_A1EmpCod ;
   private int[] P025G2_A3CliCod ;
   private String[] P025G2_A2278LegLinkS3Html ;
   private String[] P025G2_A2277LegLinkTiporec ;
}

final  class resetearecibos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P025G2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV11LiqNro ,
                                          int AV8LegNumero ,
                                          int A31LiqNro ,
                                          int A2285LinkLegNumero ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LinkLegNumero, LiqNro, EmpCod, CliCod, LegLinkS3Html, LegLinkTiporec FROM LiquidacionLegajoLinkPdf" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV11LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( ! (0==AV8LegNumero) )
      {
         addWhere(sWhereString, "(LinkLegNumero = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LiquidacionLegajoLinkPdf" ;
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
                  return conditional_P025G2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025G2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P025G3", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajoLinkPdf  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LinkLegNumero = ? AND LegLinkTiporec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

