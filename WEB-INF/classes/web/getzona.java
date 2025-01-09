package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getzona extends GXProcedure
{
   public getzona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getzona.class ), "" );
   }

   public getzona( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getzona.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      getzona.this.AV9ZonCod = aP0;
      getzona.this.aP1 = aP1;
      getzona.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00B22 */
      pr_default.execute(0, new Object[] {AV9ZonCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20ZonCod = P00B22_A20ZonCod[0] ;
         A342ZonDescrip = P00B22_A342ZonDescrip[0] ;
         AV10ZonDescrip = A342ZonDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getzona.this.AV10ZonDescrip;
      this.aP2[0] = getzona.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ZonDescrip = "" ;
      scmdbuf = "" ;
      P00B22_A20ZonCod = new String[] {""} ;
      P00B22_A342ZonDescrip = new String[] {""} ;
      A20ZonCod = "" ;
      A342ZonDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getzona__default(),
         new Object[] {
             new Object[] {
            P00B22_A20ZonCod, P00B22_A342ZonDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9ZonCod ;
   private String scmdbuf ;
   private String A20ZonCod ;
   private boolean AV11existe ;
   private String AV10ZonDescrip ;
   private String A342ZonDescrip ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00B22_A20ZonCod ;
   private String[] P00B22_A342ZonDescrip ;
}

final  class getzona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00B22", "SELECT ZonCod, ZonDescrip FROM Zona WHERE ZonCod = ( ?) ORDER BY ZonCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

