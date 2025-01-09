package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsubtrestadias extends GXProcedure
{
   public getsubtrestadias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsubtrestadias.class ), "" );
   }

   public getsubtrestadias( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 )
   {
      getsubtrestadias.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      getsubtrestadias.this.AV9TipoConCod = aP0;
      getsubtrestadias.this.AV10SubTipoConCod1 = aP1;
      getsubtrestadias.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ZQ2 */
      pr_default.execute(0, new Object[] {AV9TipoConCod, AV10SubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P01ZQ2_A38SubTipoConCod1[0] ;
         A37TipoConCod = P01ZQ2_A37TipoConCod[0] ;
         A2134SubTRestaDias = P01ZQ2_A2134SubTRestaDias[0] ;
         AV8SubTRestaDias = A2134SubTRestaDias ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsubtrestadias.this.AV8SubTRestaDias;
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
      P01ZQ2_A38SubTipoConCod1 = new String[] {""} ;
      P01ZQ2_A37TipoConCod = new String[] {""} ;
      P01ZQ2_A2134SubTRestaDias = new boolean[] {false} ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsubtrestadias__default(),
         new Object[] {
             new Object[] {
            P01ZQ2_A38SubTipoConCod1, P01ZQ2_A37TipoConCod, P01ZQ2_A2134SubTRestaDias
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9TipoConCod ;
   private String AV10SubTipoConCod1 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private boolean AV8SubTRestaDias ;
   private boolean A2134SubTRestaDias ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZQ2_A38SubTipoConCod1 ;
   private String[] P01ZQ2_A37TipoConCod ;
   private boolean[] P01ZQ2_A2134SubTRestaDias ;
}

final  class getsubtrestadias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZQ2", "SELECT SubTipoConCod1, TipoConCod, SubTRestaDias FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

