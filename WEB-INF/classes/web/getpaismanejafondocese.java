package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaismanejafondocese extends GXProcedure
{
   public getpaismanejafondocese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaismanejafondocese.class ), "" );
   }

   public getpaismanejafondocese( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 )
   {
      getpaismanejafondocese.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             boolean[] aP1 )
   {
      getpaismanejafondocese.this.AV10PaiCod = aP0;
      getpaismanejafondocese.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CY2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01CY2_A46PaiCod[0] ;
         A1402PaiFondoCese = P01CY2_A1402PaiFondoCese[0] ;
         AV11PaiFondoCese = A1402PaiFondoCese ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaismanejafondocese.this.AV11PaiFondoCese;
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
      P01CY2_A46PaiCod = new short[1] ;
      P01CY2_A1402PaiFondoCese = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaismanejafondocese__default(),
         new Object[] {
             new Object[] {
            P01CY2_A46PaiCod, P01CY2_A1402PaiFondoCese
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean AV11PaiFondoCese ;
   private boolean A1402PaiFondoCese ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01CY2_A46PaiCod ;
   private boolean[] P01CY2_A1402PaiFondoCese ;
}

final  class getpaismanejafondocese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CY2", "SELECT PaiCod, PaiFondoCese FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

