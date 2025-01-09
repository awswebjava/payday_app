package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoaplganancias extends GXProcedure
{
   public gettipoaplganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoaplganancias.class ), "" );
   }

   public gettipoaplganancias( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String[] aP2 )
   {
      gettipoaplganancias.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      gettipoaplganancias.this.AV11CliCod = aP0;
      gettipoaplganancias.this.AV10AplIIGG = aP1;
      gettipoaplganancias.this.aP2 = aP2;
      gettipoaplganancias.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8existe = false ;
      /* Using cursor P021G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10AplIIGG)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1112AplIIGG = P021G2_A1112AplIIGG[0] ;
         A3CliCod = P021G2_A3CliCod[0] ;
         A1113AplIIGGNom = P021G2_A1113AplIIGGNom[0] ;
         AV9AplIIGGNom = A1113AplIIGGNom ;
         AV8existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipoaplganancias.this.AV9AplIIGGNom;
      this.aP3[0] = gettipoaplganancias.this.AV8existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9AplIIGGNom = "" ;
      scmdbuf = "" ;
      P021G2_A1112AplIIGG = new short[1] ;
      P021G2_A3CliCod = new int[1] ;
      P021G2_A1113AplIIGGNom = new String[] {""} ;
      A1113AplIIGGNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoaplganancias__default(),
         new Object[] {
             new Object[] {
            P021G2_A1112AplIIGG, P021G2_A3CliCod, P021G2_A1113AplIIGGNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8existe ;
   private String AV9AplIIGGNom ;
   private String A1113AplIIGGNom ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P021G2_A1112AplIIGG ;
   private int[] P021G2_A3CliCod ;
   private String[] P021G2_A1113AplIIGGNom ;
}

final  class gettipoaplganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P021G2", "SELECT AplIIGG, CliCod, AplIIGGNom FROM tipo_aplicacion_ganancias WHERE CliCod = ? and AplIIGG = ? ORDER BY CliCod, AplIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

