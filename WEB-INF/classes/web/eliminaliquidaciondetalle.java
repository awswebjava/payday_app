package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminaliquidaciondetalle extends GXProcedure
{
   public eliminaliquidaciondetalle( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminaliquidaciondetalle.class ), "" );
   }

   public eliminaliquidaciondetalle( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      eliminaliquidaciondetalle.this.AV12CliCod = aP0;
      eliminaliquidaciondetalle.this.AV9EmpCod = aP1;
      eliminaliquidaciondetalle.this.AV10LiqNro = aP2;
      eliminaliquidaciondetalle.this.AV8LegNumero = aP3;
      eliminaliquidaciondetalle.this.AV11ConCodigo = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8LegNumero) ,
                                           AV11ConCodigo ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A394DConCodigo ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P00A42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV8LegNumero), AV11ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P00A42_A394DConCodigo[0] ;
         A6LegNumero = P00A42_A6LegNumero[0] ;
         A31LiqNro = P00A42_A31LiqNro[0] ;
         A1EmpCod = P00A42_A1EmpCod[0] ;
         A3CliCod = P00A42_A3CliCod[0] ;
         A81LiqDSecuencial = P00A42_A81LiqDSecuencial[0] ;
         /* Using cursor P00A43 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
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
      A394DConCodigo = "" ;
      P00A42_A394DConCodigo = new String[] {""} ;
      P00A42_A6LegNumero = new int[1] ;
      P00A42_A31LiqNro = new int[1] ;
      P00A42_A1EmpCod = new short[1] ;
      P00A42_A3CliCod = new int[1] ;
      P00A42_A81LiqDSecuencial = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminaliquidaciondetalle__default(),
         new Object[] {
             new Object[] {
            P00A42_A394DConCodigo, P00A42_A6LegNumero, P00A42_A31LiqNro, P00A42_A1EmpCod, P00A42_A3CliCod, P00A42_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LiqNro ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private String AV11ConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private IDataStoreProvider pr_default ;
   private String[] P00A42_A394DConCodigo ;
   private int[] P00A42_A6LegNumero ;
   private int[] P00A42_A31LiqNro ;
   private short[] P00A42_A1EmpCod ;
   private int[] P00A42_A3CliCod ;
   private int[] P00A42_A81LiqDSecuencial ;
}

final  class eliminaliquidaciondetalle__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00A42( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8LegNumero ,
                                          String AV11ConCodigo ,
                                          int A6LegNumero ,
                                          String A394DConCodigo ,
                                          int AV12CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      if ( ! (0==AV8LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         addWhere(sWhereString, "(DConCodigo = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro" ;
      scmdbuf += " FOR UPDATE OF LiquidacionDetalle" ;
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
                  return conditional_P00A42(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00A42", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00A43", "SAVEPOINT gxupdate;DELETE FROM LiquidacionDetalle  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
                  stmt.setString(sIdx, (String)parms[9], 10);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

