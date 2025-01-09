package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class autoselconafip extends GXProcedure
{
   public autoselconafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( autoselconafip.class ), "" );
   }

   public autoselconafip( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      autoselconafip.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      autoselconafip.this.AV8ConAfipSubT1 = aP0;
      autoselconafip.this.AV9ConAFIPConcepto = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV8ConAfipSubT1)==0) && (GXutil.strcmp("", AV9ConAFIPConcepto)==0) )
      {
         /* Using cursor P00G42 */
         pr_default.execute(0, new Object[] {AV8ConAfipSubT1});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A72AFIPConCod = P00G42_A72AFIPConCod[0] ;
            A388AfipConSubTipoConCod1 = P00G42_A388AfipConSubTipoConCod1[0] ;
            if ( GXutil.strcmp(GXutil.trim( A72AFIPConCod), GXutil.trim( A388AfipConSubTipoConCod1)) == 0 )
            {
               AV9ConAFIPConcepto = A72AFIPConCod ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = autoselconafip.this.AV9ConAFIPConcepto;
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
      P00G42_A72AFIPConCod = new String[] {""} ;
      P00G42_A388AfipConSubTipoConCod1 = new String[] {""} ;
      A72AFIPConCod = "" ;
      A388AfipConSubTipoConCod1 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.autoselconafip__default(),
         new Object[] {
             new Object[] {
            P00G42_A72AFIPConCod, P00G42_A388AfipConSubTipoConCod1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ConAfipSubT1 ;
   private String AV9ConAFIPConcepto ;
   private String scmdbuf ;
   private String A72AFIPConCod ;
   private String A388AfipConSubTipoConCod1 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00G42_A72AFIPConCod ;
   private String[] P00G42_A388AfipConSubTipoConCod1 ;
}

final  class autoselconafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00G42", "SELECT AFIPConCod, AfipConSubTipoConCod1 FROM AFIPConcepto WHERE AFIPConCod = ( ?) ORDER BY AFIPConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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

