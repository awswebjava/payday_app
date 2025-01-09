package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosempresa extends GXProcedure
{
   public getdatosempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosempresa.class ), "" );
   }

   public getdatosempresa( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String[] aP2 ,
                             long[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      getdatosempresa.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 ,
                        long[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 ,
                             long[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      getdatosempresa.this.AV8CliCod = aP0;
      getdatosempresa.this.AV9EmpCod = aP1;
      getdatosempresa.this.aP2 = aP2;
      getdatosempresa.this.aP3 = aP3;
      getdatosempresa.this.aP4 = aP4;
      getdatosempresa.this.aP5 = aP5;
      getdatosempresa.this.aP6 = aP6;
      getdatosempresa.this.aP7 = aP7;
      getdatosempresa.this.aP8 = aP8;
      getdatosempresa.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00B82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P00B82_A46PaiCod[0] ;
         n46PaiCod = P00B82_n46PaiCod[0] ;
         A47ProvCod = P00B82_A47ProvCod[0] ;
         n47ProvCod = P00B82_n47ProvCod[0] ;
         A48LocCod = P00B82_A48LocCod[0] ;
         n48LocCod = P00B82_n48LocCod[0] ;
         A4CliPaiCod = P00B82_A4CliPaiCod[0] ;
         n4CliPaiCod = P00B82_n4CliPaiCod[0] ;
         A1EmpCod = P00B82_A1EmpCod[0] ;
         A3CliCod = P00B82_A3CliCod[0] ;
         A2EmpNom = P00B82_A2EmpNom[0] ;
         A177EmpCUIT = P00B82_A177EmpCUIT[0] ;
         A176EmpCP = P00B82_A176EmpCP[0] ;
         n176EmpCP = P00B82_n176EmpCP[0] ;
         A178EmpDir = P00B82_A178EmpDir[0] ;
         A180EmpTel = P00B82_A180EmpTel[0] ;
         n180EmpTel = P00B82_n180EmpTel[0] ;
         A43ActCodigo = P00B82_A43ActCodigo[0] ;
         n43ActCodigo = P00B82_n43ActCodigo[0] ;
         A322ProvNom = P00B82_A322ProvNom[0] ;
         A286LocNom = P00B82_A286LocNom[0] ;
         A322ProvNom = P00B82_A322ProvNom[0] ;
         A286LocNom = P00B82_A286LocNom[0] ;
         A4CliPaiCod = P00B82_A4CliPaiCod[0] ;
         n4CliPaiCod = P00B82_n4CliPaiCod[0] ;
         /* Using cursor P00B83 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         A286LocNom = P00B83_A286LocNom[0] ;
         pr_default.close(1);
         /* Using cursor P00B84 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = P00B84_A322ProvNom[0] ;
         pr_default.close(2);
         AV10EmpNom = A2EmpNom ;
         AV14EmpCUIT = A177EmpCUIT ;
         AV11EmpCP = A176EmpCP ;
         AV13EmpDir = A178EmpDir ;
         AV12EmpTel = A180EmpTel ;
         AV15ActCodigo = A43ActCodigo ;
         AV16ProvNom = A322ProvNom ;
         AV17LocNom = A286LocNom ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdatosempresa.this.AV10EmpNom;
      this.aP3[0] = getdatosempresa.this.AV14EmpCUIT;
      this.aP4[0] = getdatosempresa.this.AV11EmpCP;
      this.aP5[0] = getdatosempresa.this.AV13EmpDir;
      this.aP6[0] = getdatosempresa.this.AV12EmpTel;
      this.aP7[0] = getdatosempresa.this.AV15ActCodigo;
      this.aP8[0] = getdatosempresa.this.AV17LocNom;
      this.aP9[0] = getdatosempresa.this.AV16ProvNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(1);
      pr_default.close(2);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10EmpNom = "" ;
      AV11EmpCP = "" ;
      AV13EmpDir = "" ;
      AV12EmpTel = "" ;
      AV15ActCodigo = "" ;
      AV17LocNom = "" ;
      AV16ProvNom = "" ;
      scmdbuf = "" ;
      P00B82_A46PaiCod = new short[1] ;
      P00B82_n46PaiCod = new boolean[] {false} ;
      P00B82_A47ProvCod = new short[1] ;
      P00B82_n47ProvCod = new boolean[] {false} ;
      P00B82_A48LocCod = new short[1] ;
      P00B82_n48LocCod = new boolean[] {false} ;
      P00B82_A4CliPaiCod = new short[1] ;
      P00B82_n4CliPaiCod = new boolean[] {false} ;
      P00B82_A1EmpCod = new short[1] ;
      P00B82_A3CliCod = new int[1] ;
      P00B82_A2EmpNom = new String[] {""} ;
      P00B82_A177EmpCUIT = new long[1] ;
      P00B82_A176EmpCP = new String[] {""} ;
      P00B82_n176EmpCP = new boolean[] {false} ;
      P00B82_A178EmpDir = new String[] {""} ;
      P00B82_A180EmpTel = new String[] {""} ;
      P00B82_n180EmpTel = new boolean[] {false} ;
      P00B82_A43ActCodigo = new String[] {""} ;
      P00B82_n43ActCodigo = new boolean[] {false} ;
      P00B82_A322ProvNom = new String[] {""} ;
      P00B82_A286LocNom = new String[] {""} ;
      A2EmpNom = "" ;
      A176EmpCP = "" ;
      A178EmpDir = "" ;
      A180EmpTel = "" ;
      A43ActCodigo = "" ;
      A322ProvNom = "" ;
      A286LocNom = "" ;
      P00B83_A286LocNom = new String[] {""} ;
      P00B84_A322ProvNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosempresa__default(),
         new Object[] {
             new Object[] {
            P00B82_A46PaiCod, P00B82_n46PaiCod, P00B82_A47ProvCod, P00B82_n47ProvCod, P00B82_A48LocCod, P00B82_n48LocCod, P00B82_A4CliPaiCod, P00B82_n4CliPaiCod, P00B82_A1EmpCod, P00B82_A3CliCod,
            P00B82_A2EmpNom, P00B82_A177EmpCUIT, P00B82_A176EmpCP, P00B82_n176EmpCP, P00B82_A178EmpDir, P00B82_A180EmpTel, P00B82_n180EmpTel, P00B82_A43ActCodigo, P00B82_n43ActCodigo, P00B82_A322ProvNom,
            P00B82_A286LocNom
            }
            , new Object[] {
            P00B83_A286LocNom
            }
            , new Object[] {
            P00B84_A322ProvNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short A4CliPaiCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private long AV14EmpCUIT ;
   private long A177EmpCUIT ;
   private String AV11EmpCP ;
   private String AV15ActCodigo ;
   private String scmdbuf ;
   private String A176EmpCP ;
   private String A43ActCodigo ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n4CliPaiCod ;
   private boolean n176EmpCP ;
   private boolean n180EmpTel ;
   private boolean n43ActCodigo ;
   private String AV10EmpNom ;
   private String AV13EmpDir ;
   private String AV12EmpTel ;
   private String AV17LocNom ;
   private String AV16ProvNom ;
   private String A2EmpNom ;
   private String A178EmpDir ;
   private String A180EmpTel ;
   private String A322ProvNom ;
   private String A286LocNom ;
   private String[] aP9 ;
   private String[] aP2 ;
   private long[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private short[] P00B82_A46PaiCod ;
   private boolean[] P00B82_n46PaiCod ;
   private short[] P00B82_A47ProvCod ;
   private boolean[] P00B82_n47ProvCod ;
   private short[] P00B82_A48LocCod ;
   private boolean[] P00B82_n48LocCod ;
   private short[] P00B82_A4CliPaiCod ;
   private boolean[] P00B82_n4CliPaiCod ;
   private short[] P00B82_A1EmpCod ;
   private int[] P00B82_A3CliCod ;
   private String[] P00B82_A2EmpNom ;
   private long[] P00B82_A177EmpCUIT ;
   private String[] P00B82_A176EmpCP ;
   private boolean[] P00B82_n176EmpCP ;
   private String[] P00B82_A178EmpDir ;
   private String[] P00B82_A180EmpTel ;
   private boolean[] P00B82_n180EmpTel ;
   private String[] P00B82_A43ActCodigo ;
   private boolean[] P00B82_n43ActCodigo ;
   private String[] P00B82_A322ProvNom ;
   private String[] P00B82_A286LocNom ;
   private String[] P00B83_A286LocNom ;
   private String[] P00B84_A322ProvNom ;
}

final  class getdatosempresa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00B82", "SELECT T1.PaiCod, T1.ProvCod, T1.LocCod, T4.CliPaiCod, T1.EmpCod, T1.CliCod, T1.EmpNom, T1.EmpCUIT, T1.EmpCP, T1.EmpDir, T1.EmpTel, T1.ActCodigo, T2.ProvNom, T3.LocNom FROM (((Empresa T1 LEFT JOIN Provincia T2 ON T2.PaiCod = T1.PaiCod AND T2.ProvCod = T1.ProvCod) LEFT JOIN Localidad T3 ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod AND T3.LocCod = T1.LocCod) INNER JOIN Cliente T4 ON T4.CliCod = T1.CliCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00B83", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00B84", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((int[]) buf[9])[0] = rslt.getInt(6);
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((long[]) buf[11])[0] = rslt.getLong(8);
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(10);
               ((String[]) buf[15])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(12, 8);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(13);
               ((String[]) buf[20])[0] = rslt.getVarchar(14);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
      }
   }

}

