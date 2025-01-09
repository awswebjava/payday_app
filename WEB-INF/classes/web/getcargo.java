package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcargo extends GXProcedure
{
   public getcargo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcargo.class ), "" );
   }

   public getcargo( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getcargo.this.aP1 = new String[] {""};
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
      getcargo.this.AV9CarCodigo = aP0;
      getcargo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AG2 */
      pr_default.execute(0, new Object[] {AV9CarCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A71CarCodigo = P00AG2_A71CarCodigo[0] ;
         A119CarDescrip = P00AG2_A119CarDescrip[0] ;
         AV8CarDescrip = A119CarDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcargo.this.AV8CarDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CarDescrip = "" ;
      scmdbuf = "" ;
      P00AG2_A71CarCodigo = new String[] {""} ;
      P00AG2_A119CarDescrip = new String[] {""} ;
      A71CarCodigo = "" ;
      A119CarDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcargo__default(),
         new Object[] {
             new Object[] {
            P00AG2_A71CarCodigo, P00AG2_A119CarDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9CarCodigo ;
   private String scmdbuf ;
   private String A71CarCodigo ;
   private String AV8CarDescrip ;
   private String A119CarDescrip ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AG2_A71CarCodigo ;
   private String[] P00AG2_A119CarDescrip ;
}

final  class getcargo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AG2", "SELECT CarCodigo, CarDescrip FROM Cargo WHERE CarCodigo = ( ?) ORDER BY CarCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

