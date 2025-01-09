package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondicionlikedescrip extends GXProcedure
{
   public getcondicionlikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondicionlikedescrip.class ), "" );
   }

   public getcondicionlikedescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              short[] aP1 )
   {
      getcondicionlikedescrip.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        short[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             short[] aP1 ,
                             boolean[] aP2 )
   {
      getcondicionlikedescrip.this.AV8CondiDescri = aP0;
      getcondicionlikedescrip.this.aP1 = aP1;
      getcondicionlikedescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV8CondiDescri = GXutil.concat( GXutil.rtrim( AV8CondiDescri), "%", "") ;
      /* Using cursor P00MG2 */
      pr_default.execute(0, new Object[] {lV8CondiDescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A686CondiDescriSinAc = P00MG2_A686CondiDescriSinAc[0] ;
         A17CondiCodigo = P00MG2_A17CondiCodigo[0] ;
         AV9CondiCodigo = A17CondiCodigo ;
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
      this.aP1[0] = getcondicionlikedescrip.this.AV9CondiCodigo;
      this.aP2[0] = getcondicionlikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      lV8CondiDescri = "" ;
      scmdbuf = "" ;
      P00MG2_A686CondiDescriSinAc = new String[] {""} ;
      P00MG2_A17CondiCodigo = new short[1] ;
      A686CondiDescriSinAc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondicionlikedescrip__default(),
         new Object[] {
             new Object[] {
            P00MG2_A686CondiDescriSinAc, P00MG2_A17CondiCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9CondiCodigo ;
   private short A17CondiCodigo ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean AV11existe ;
   private String AV8CondiDescri ;
   private String lV8CondiDescri ;
   private String A686CondiDescriSinAc ;
   private boolean[] aP2 ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00MG2_A686CondiDescriSinAc ;
   private short[] P00MG2_A17CondiCodigo ;
}

final  class getcondicionlikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MG2", "SELECT CondiDescriSinAc, CondiCodigo FROM CondicionAFIP WHERE CondiDescriSinAc like '%' || ? ORDER BY CondiCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
      }
   }

}

