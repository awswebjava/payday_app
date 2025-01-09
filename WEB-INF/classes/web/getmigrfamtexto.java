package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrfamtexto extends GXProcedure
{
   public getmigrfamtexto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrfamtexto.class ), "" );
   }

   public getmigrfamtexto( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String[] aP4 )
   {
      getmigrfamtexto.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      getmigrfamtexto.this.AV8CliCod = aP0;
      getmigrfamtexto.this.AV9EmpCod = aP1;
      getmigrfamtexto.this.AV13MigrLegNumero = aP2;
      getmigrfamtexto.this.AV11MigrLegFamSec = aP3;
      getmigrfamtexto.this.aP4 = aP4;
      getmigrfamtexto.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01YY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV13MigrLegNumero), Short.valueOf(AV11MigrLegFamSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2078MigrLegFamSec = P01YY2_A2078MigrLegFamSec[0] ;
         A87MigrLegNumero = P01YY2_A87MigrLegNumero[0] ;
         A1EmpCod = P01YY2_A1EmpCod[0] ;
         A3CliCod = P01YY2_A3CliCod[0] ;
         A2084MigrLegFamErrores = P01YY2_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = P01YY2_A2085MigrLegFamWarnings[0] ;
         AV10MigrLegFamErrores = A2084MigrLegFamErrores ;
         AV12MigrLegFamWarnings = A2085MigrLegFamWarnings ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getmigrfamtexto.this.AV10MigrLegFamErrores;
      this.aP5[0] = getmigrfamtexto.this.AV12MigrLegFamWarnings;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10MigrLegFamErrores = "" ;
      AV12MigrLegFamWarnings = "" ;
      scmdbuf = "" ;
      P01YY2_A2078MigrLegFamSec = new short[1] ;
      P01YY2_A87MigrLegNumero = new int[1] ;
      P01YY2_A1EmpCod = new short[1] ;
      P01YY2_A3CliCod = new int[1] ;
      P01YY2_A2084MigrLegFamErrores = new String[] {""} ;
      P01YY2_A2085MigrLegFamWarnings = new String[] {""} ;
      A2084MigrLegFamErrores = "" ;
      A2085MigrLegFamWarnings = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrfamtexto__default(),
         new Object[] {
             new Object[] {
            P01YY2_A2078MigrLegFamSec, P01YY2_A87MigrLegNumero, P01YY2_A1EmpCod, P01YY2_A3CliCod, P01YY2_A2084MigrLegFamErrores, P01YY2_A2085MigrLegFamWarnings
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11MigrLegFamSec ;
   private short A2078MigrLegFamSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV10MigrLegFamErrores ;
   private String AV12MigrLegFamWarnings ;
   private String A2084MigrLegFamErrores ;
   private String A2085MigrLegFamWarnings ;
   private String[] aP5 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P01YY2_A2078MigrLegFamSec ;
   private int[] P01YY2_A87MigrLegNumero ;
   private short[] P01YY2_A1EmpCod ;
   private int[] P01YY2_A3CliCod ;
   private String[] P01YY2_A2084MigrLegFamErrores ;
   private String[] P01YY2_A2085MigrLegFamWarnings ;
}

final  class getmigrfamtexto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YY2", "SELECT MigrLegFamSec, MigrLegNumero, EmpCod, CliCod, MigrLegFamErrores, MigrLegFamWarnings FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? and MigrLegFamSec = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

