package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondicion extends GXProcedure
{
   public getcondicion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondicion.class ), "" );
   }

   public getcondicion( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String[] aP1 )
   {
      getcondicion.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      getcondicion.this.AV9CondiCodigo = aP0;
      getcondicion.this.aP1 = aP1;
      getcondicion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AE2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9CondiCodigo)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A17CondiCodigo = P00AE2_A17CondiCodigo[0] ;
         A144CondiDescri = P00AE2_A144CondiDescri[0] ;
         AV8CondiDescri = A144CondiDescri ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcondicion.this.AV8CondiDescri;
      this.aP2[0] = getcondicion.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CondiDescri = "" ;
      scmdbuf = "" ;
      P00AE2_A17CondiCodigo = new short[1] ;
      P00AE2_A144CondiDescri = new String[] {""} ;
      A144CondiDescri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondicion__default(),
         new Object[] {
             new Object[] {
            P00AE2_A17CondiCodigo, P00AE2_A144CondiDescri
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
   private String A144CondiDescri ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P00AE2_A17CondiCodigo ;
   private String[] P00AE2_A144CondiDescri ;
}

final  class getcondicion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AE2", "SELECT CondiCodigo, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ORDER BY CondiCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

