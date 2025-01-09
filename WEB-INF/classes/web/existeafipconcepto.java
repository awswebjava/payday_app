package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class existeafipconcepto extends GXProcedure
{
   public existeafipconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( existeafipconcepto.class ), "" );
   }

   public existeafipconcepto( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      existeafipconcepto.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      existeafipconcepto.this.AV8AFIPConCod = aP0;
      existeafipconcepto.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9existe = false ;
      /* Using cursor P00G92 */
      pr_default.execute(0, new Object[] {AV8AFIPConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A72AFIPConCod = P00G92_A72AFIPConCod[0] ;
         AV9existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = existeafipconcepto.this.AV9existe;
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
      P00G92_A72AFIPConCod = new String[] {""} ;
      A72AFIPConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.existeafipconcepto__default(),
         new Object[] {
             new Object[] {
            P00G92_A72AFIPConCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8AFIPConCod ;
   private String scmdbuf ;
   private String A72AFIPConCod ;
   private boolean AV9existe ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00G92_A72AFIPConCod ;
}

final  class existeafipconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00G92", "SELECT AFIPConCod FROM AFIPConcepto WHERE AFIPConCod = ( ?) ORDER BY AFIPConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
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
               stmt.setString(1, (String)parms[0], 6);
               return;
      }
   }

}

