package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqlegnumeros extends GXProcedure
{
   public getliqlegnumeros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqlegnumeros.class ), "" );
   }

   public getliqlegnumeros( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Integer> executeUdp( int aP0 ,
                                                  short aP1 ,
                                                  int aP2 ,
                                                  boolean aP3 )
   {
      getliqlegnumeros.this.aP4 = new GXSimpleCollection[] {new GXSimpleCollection<Integer>(Integer.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        GXSimpleCollection<Integer>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             GXSimpleCollection<Integer>[] aP4 )
   {
      getliqlegnumeros.this.AV10clicod = aP0;
      getliqlegnumeros.this.AV8empcod = aP1;
      getliqlegnumeros.this.AV9liqnro = aP2;
      getliqlegnumeros.this.AV12soloOK = aP3;
      getliqlegnumeros.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV12soloOK) ,
                                           A891LiqLegError ,
                                           Integer.valueOf(AV10clicod) ,
                                           Short.valueOf(AV8empcod) ,
                                           Integer.valueOf(AV9liqnro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P012H2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10clicod), Short.valueOf(AV8empcod), Integer.valueOf(AV9liqnro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A891LiqLegError = P012H2_A891LiqLegError[0] ;
         A31LiqNro = P012H2_A31LiqNro[0] ;
         A1EmpCod = P012H2_A1EmpCod[0] ;
         A3CliCod = P012H2_A3CliCod[0] ;
         A6LegNumero = P012H2_A6LegNumero[0] ;
         AV11legnumero.add((int)(A6LegNumero), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getliqlegnumeros.this.AV11legnumero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11legnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      scmdbuf = "" ;
      A891LiqLegError = "" ;
      P012H2_A891LiqLegError = new String[] {""} ;
      P012H2_A31LiqNro = new int[1] ;
      P012H2_A1EmpCod = new short[1] ;
      P012H2_A3CliCod = new int[1] ;
      P012H2_A6LegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqlegnumeros__default(),
         new Object[] {
             new Object[] {
            P012H2_A891LiqLegError, P012H2_A31LiqNro, P012H2_A1EmpCod, P012H2_A3CliCod, P012H2_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10clicod ;
   private int AV9liqnro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private boolean AV12soloOK ;
   private String A891LiqLegError ;
   private GXSimpleCollection<Integer> AV11legnumero ;
   private GXSimpleCollection<Integer>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P012H2_A891LiqLegError ;
   private int[] P012H2_A31LiqNro ;
   private short[] P012H2_A1EmpCod ;
   private int[] P012H2_A3CliCod ;
   private int[] P012H2_A6LegNumero ;
}

final  class getliqlegnumeros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P012H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV12soloOK ,
                                          String A891LiqLegError ,
                                          int AV10clicod ,
                                          short AV8empcod ,
                                          int AV9liqnro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LiqLegError, LiqNro, EmpCod, CliCod, LegNumero FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      if ( AV12soloOK )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from LiqLegError))=0))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro" ;
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
                  return conditional_P012H2(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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

