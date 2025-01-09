package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpropiedadadicional extends GXProcedure
{
   public getpropiedadadicional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpropiedadadicional.class ), "" );
   }

   public getpropiedadadicional( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getpropiedadadicional.this.aP2 = new boolean[] {false};
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
      getpropiedadadicional.this.AV10propCod = aP0;
      getpropiedadadicional.this.aP1 = aP1;
      getpropiedadadicional.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02782 */
      pr_default.execute(0, new Object[] {AV10propCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2227propCod = P02782_A2227propCod[0] ;
         A2228propDesc = P02782_A2228propDesc[0] ;
         AV9propDesc = A2228propDesc ;
         AV8existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpropiedadadicional.this.AV9propDesc;
      this.aP2[0] = getpropiedadadicional.this.AV8existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9propDesc = "" ;
      scmdbuf = "" ;
      P02782_A2227propCod = new String[] {""} ;
      P02782_A2228propDesc = new String[] {""} ;
      A2227propCod = "" ;
      A2228propDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpropiedadadicional__default(),
         new Object[] {
             new Object[] {
            P02782_A2227propCod, P02782_A2228propDesc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10propCod ;
   private String scmdbuf ;
   private String A2227propCod ;
   private boolean AV8existe ;
   private String AV9propDesc ;
   private String A2228propDesc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P02782_A2227propCod ;
   private String[] P02782_A2228propDesc ;
}

final  class getpropiedadadicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02782", "SELECT propCod, propDesc FROM propiedades_adicionales WHERE propCod = ( ?) ORDER BY propCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

