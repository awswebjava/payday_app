package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsvg extends GXProcedure
{
   public getsvg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsvg.class ), "" );
   }

   public getsvg( int remoteHandle ,
                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getsvg.this.aP1 = new String[] {""};
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
      getsvg.this.AV9SVGId = aP0;
      getsvg.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VF2 */
      pr_default.execute(0, new Object[] {AV9SVGId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1935SVGId = P01VF2_A1935SVGId[0] ;
         A1936SVGValor = P01VF2_A1936SVGValor[0] ;
         AV8SVGValor = A1936SVGValor ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsvg.this.AV8SVGValor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SVGValor = "" ;
      scmdbuf = "" ;
      P01VF2_A1935SVGId = new String[] {""} ;
      P01VF2_A1936SVGValor = new String[] {""} ;
      A1935SVGId = "" ;
      A1936SVGValor = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsvg__default(),
         new Object[] {
             new Object[] {
            P01VF2_A1935SVGId, P01VF2_A1936SVGValor
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9SVGId ;
   private String scmdbuf ;
   private String A1935SVGId ;
   private String AV8SVGValor ;
   private String A1936SVGValor ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01VF2_A1935SVGId ;
   private String[] P01VF2_A1936SVGValor ;
}

final  class getsvg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VF2", "SELECT SVGId, SVGValor FROM SVG WHERE SVGId = ( ?) ORDER BY SVGId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
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

