package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getestadocivildescrip extends GXProcedure
{
   public getestadocivildescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getestadocivildescrip.class ), "" );
   }

   public getestadocivildescrip( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 )
   {
      getestadocivildescrip.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             String[] aP1 )
   {
      getestadocivildescrip.this.AV8EstaCivilCod = aP0;
      getestadocivildescrip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02AS2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8EstaCivilCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1748EstaCivilCod = P02AS2_A1748EstaCivilCod[0] ;
         A1749EstaCivilDescrip = P02AS2_A1749EstaCivilDescrip[0] ;
         AV9EstaCivilDescrip = A1749EstaCivilDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getestadocivildescrip.this.AV9EstaCivilDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9EstaCivilDescrip = "" ;
      scmdbuf = "" ;
      P02AS2_A1748EstaCivilCod = new short[1] ;
      P02AS2_A1749EstaCivilDescrip = new String[] {""} ;
      A1749EstaCivilDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getestadocivildescrip__default(),
         new Object[] {
             new Object[] {
            P02AS2_A1748EstaCivilCod, P02AS2_A1749EstaCivilDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EstaCivilCod ;
   private short A1748EstaCivilCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV9EstaCivilDescrip ;
   private String A1749EstaCivilDescrip ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P02AS2_A1748EstaCivilCod ;
   private String[] P02AS2_A1749EstaCivilDescrip ;
}

final  class getestadocivildescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AS2", "SELECT EstaCivilCod, EstaCivilDescrip FROM Estados_civiles WHERE EstaCivilCod = ? ORDER BY EstaCivilCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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

