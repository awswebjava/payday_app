package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsiniestradopordescrip extends GXProcedure
{
   public getsiniestradopordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsiniestradopordescrip.class ), "" );
   }

   public getsiniestradopordescrip( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getsiniestradopordescrip.this.aP2 = new boolean[] {false};
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
      getsiniestradopordescrip.this.AV8SinieDescri = aP0;
      getsiniestradopordescrip.this.aP1 = aP1;
      getsiniestradopordescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002G2 */
      pr_default.execute(0, new Object[] {AV8SinieDescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A688SinieDescriSinAc = P002G2_A688SinieDescriSinAc[0] ;
         A19SinieCodigo = P002G2_A19SinieCodigo[0] ;
         AV9SinieCodigo = A19SinieCodigo ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsiniestradopordescrip.this.AV9SinieCodigo;
      this.aP2[0] = getsiniestradopordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SinieCodigo = "" ;
      scmdbuf = "" ;
      P002G2_A688SinieDescriSinAc = new String[] {""} ;
      P002G2_A19SinieCodigo = new String[] {""} ;
      A688SinieDescriSinAc = "" ;
      A19SinieCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsiniestradopordescrip__default(),
         new Object[] {
             new Object[] {
            P002G2_A688SinieDescriSinAc, P002G2_A19SinieCodigo
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
   private String A688SinieDescriSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P002G2_A688SinieDescriSinAc ;
   private String[] P002G2_A19SinieCodigo ;
}

final  class getsiniestradopordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002G2", "SELECT SinieDescriSinAc, SinieCodigo FROM Siniestrado WHERE SinieDescriSinAc = ( ?) ORDER BY SinieCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
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
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}

