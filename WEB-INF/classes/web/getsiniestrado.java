package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsiniestrado extends GXProcedure
{
   public getsiniestrado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsiniestrado.class ), "" );
   }

   public getsiniestrado( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getsiniestrado.this.aP2 = new boolean[] {false};
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
      getsiniestrado.this.AV9SinieCodigo = aP0;
      getsiniestrado.this.aP1 = aP1;
      getsiniestrado.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AF2 */
      pr_default.execute(0, new Object[] {AV9SinieCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19SinieCodigo = P00AF2_A19SinieCodigo[0] ;
         A333SinieDescri = P00AF2_A333SinieDescri[0] ;
         AV8SinieDescri = A333SinieDescri ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsiniestrado.this.AV8SinieDescri;
      this.aP2[0] = getsiniestrado.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SinieDescri = "" ;
      scmdbuf = "" ;
      P00AF2_A19SinieCodigo = new String[] {""} ;
      P00AF2_A333SinieDescri = new String[] {""} ;
      A19SinieCodigo = "" ;
      A333SinieDescri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsiniestrado__default(),
         new Object[] {
             new Object[] {
            P00AF2_A19SinieCodigo, P00AF2_A333SinieDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9SinieCodigo ;
   private String scmdbuf ;
   private String A19SinieCodigo ;
   private boolean AV11existe ;
   private String AV8SinieDescri ;
   private String A333SinieDescri ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AF2_A19SinieCodigo ;
   private String[] P00AF2_A333SinieDescri ;
}

final  class getsiniestrado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AF2", "SELECT SinieCodigo, SinieDescri FROM Siniestrado WHERE SinieCodigo = ( ?) ORDER BY SinieCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

