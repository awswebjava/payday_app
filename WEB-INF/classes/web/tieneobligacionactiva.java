package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tieneobligacionactiva extends GXProcedure
{
   public tieneobligacionactiva( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tieneobligacionactiva.class ), "" );
   }

   public tieneobligacionactiva( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short aP3 ,
                              String aP4 )
   {
      tieneobligacionactiva.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      tieneobligacionactiva.this.AV8CliCod = aP0;
      tieneobligacionactiva.this.AV9EmpCod = aP1;
      tieneobligacionactiva.this.AV10LegNumero = aP2;
      tieneobligacionactiva.this.AV11TipoOblSec = aP3;
      tieneobligacionactiva.this.AV14OblConcepto = aP4;
      tieneobligacionactiva.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV11TipoOblSec) ,
                                           AV14OblConcepto ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A2343OblConcepto ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT
                                           }
      });
      /* Using cursor P01AA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV11TipoOblSec), AV14OblConcepto});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2343OblConcepto = P01AA2_A2343OblConcepto[0] ;
         A1173OblEstado = P01AA2_A1173OblEstado[0] ;
         A1163TipoOblSec = P01AA2_A1163TipoOblSec[0] ;
         A6LegNumero = P01AA2_A6LegNumero[0] ;
         A1EmpCod = P01AA2_A1EmpCod[0] ;
         A3CliCod = P01AA2_A3CliCod[0] ;
         A1172OblSecuencial = P01AA2_A1172OblSecuencial[0] ;
         AV13tiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = tieneobligacionactiva.this.AV13tiene;
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
      A2343OblConcepto = "" ;
      P01AA2_A2343OblConcepto = new String[] {""} ;
      P01AA2_A1173OblEstado = new byte[1] ;
      P01AA2_A1163TipoOblSec = new short[1] ;
      P01AA2_A6LegNumero = new int[1] ;
      P01AA2_A1EmpCod = new short[1] ;
      P01AA2_A3CliCod = new int[1] ;
      P01AA2_A1172OblSecuencial = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tieneobligacionactiva__default(),
         new Object[] {
             new Object[] {
            P01AA2_A2343OblConcepto, P01AA2_A1173OblEstado, P01AA2_A1163TipoOblSec, P01AA2_A6LegNumero, P01AA2_A1EmpCod, P01AA2_A3CliCod, P01AA2_A1172OblSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1173OblEstado ;
   private short AV9EmpCod ;
   private short AV11TipoOblSec ;
   private short A1163TipoOblSec ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV14OblConcepto ;
   private String scmdbuf ;
   private String A2343OblConcepto ;
   private boolean AV13tiene ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01AA2_A2343OblConcepto ;
   private byte[] P01AA2_A1173OblEstado ;
   private short[] P01AA2_A1163TipoOblSec ;
   private int[] P01AA2_A6LegNumero ;
   private short[] P01AA2_A1EmpCod ;
   private int[] P01AA2_A3CliCod ;
   private short[] P01AA2_A1172OblSecuencial ;
}

final  class tieneobligacionactiva__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01AA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV11TipoOblSec ,
                                          String AV14OblConcepto ,
                                          short A1163TipoOblSec ,
                                          String A2343OblConcepto ,
                                          byte A1173OblEstado ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT OblConcepto, OblEstado, TipoOblSec, LegNumero, EmpCod, CliCod, OblSecuencial FROM Obligacion" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(OblEstado = 1)");
      if ( ! (0==AV11TipoOblSec) )
      {
         addWhere(sWhereString, "(TipoOblSec = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV14OblConcepto)==0) )
      {
         addWhere(sWhereString, "(OblConcepto = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, TipoOblSec" ;
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
                  return conditional_P01AA2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 10);
               }
               return;
      }
   }

}

