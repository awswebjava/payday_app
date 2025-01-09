package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliiggnom extends GXProcedure
{
   public getapliiggnom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliiggnom.class ), "" );
   }

   public getapliiggnom( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      getapliiggnom.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getapliiggnom.this.AV10CliCod = aP0;
      getapliiggnom.this.AV8AplIIGG = aP1;
      getapliiggnom.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P017J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8AplIIGG)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1112AplIIGG = P017J2_A1112AplIIGG[0] ;
         A3CliCod = P017J2_A3CliCod[0] ;
         A1113AplIIGGNom = P017J2_A1113AplIIGGNom[0] ;
         AV11AplIIGGNom = A1113AplIIGGNom ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getapliiggnom.this.AV11AplIIGGNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11AplIIGGNom = "" ;
      scmdbuf = "" ;
      P017J2_A1112AplIIGG = new short[1] ;
      P017J2_A3CliCod = new int[1] ;
      P017J2_A1113AplIIGGNom = new String[] {""} ;
      A1113AplIIGGNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getapliiggnom__default(),
         new Object[] {
             new Object[] {
            P017J2_A1112AplIIGG, P017J2_A3CliCod, P017J2_A1113AplIIGGNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV11AplIIGGNom ;
   private String A1113AplIIGGNom ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P017J2_A1112AplIIGG ;
   private int[] P017J2_A3CliCod ;
   private String[] P017J2_A1113AplIIGGNom ;
}

final  class getapliiggnom__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017J2", "SELECT AplIIGG, CliCod, AplIIGGNom FROM tipo_aplicacion_ganancias WHERE CliCod = ? and AplIIGG = ? ORDER BY CliCod, AplIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
      }
   }

}

