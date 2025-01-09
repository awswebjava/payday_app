package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantidadsub2 extends GXProcedure
{
   public cantidadsub2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantidadsub2.class ), "" );
   }

   public cantidadsub2( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            String aP1 )
   {
      cantidadsub2.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             short[] aP2 )
   {
      cantidadsub2.this.AV9TipoConCod = aP0;
      cantidadsub2.this.AV10SubTipoConCod1 = aP1;
      cantidadsub2.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8cantidadSub2 = (short)(0) ;
      /* Using cursor P012O2 */
      pr_default.execute(0, new Object[] {AV9TipoConCod, AV10SubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P012O2_A38SubTipoConCod1[0] ;
         A37TipoConCod = P012O2_A37TipoConCod[0] ;
         A372SubTipoConDes2 = P012O2_A372SubTipoConDes2[0] ;
         A39SubTipoConCod2 = P012O2_A39SubTipoConCod2[0] ;
         AV8cantidadSub2 = (short)(AV8cantidadSub2+1) ;
         if ( AV8cantidadSub2 == 2 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = cantidadsub2.this.AV8cantidadSub2;
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
      P012O2_A38SubTipoConCod1 = new String[] {""} ;
      P012O2_A37TipoConCod = new String[] {""} ;
      P012O2_A372SubTipoConDes2 = new String[] {""} ;
      P012O2_A39SubTipoConCod2 = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      A372SubTipoConDes2 = "" ;
      A39SubTipoConCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cantidadsub2__default(),
         new Object[] {
             new Object[] {
            P012O2_A38SubTipoConCod1, P012O2_A37TipoConCod, P012O2_A372SubTipoConDes2, P012O2_A39SubTipoConCod2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8cantidadSub2 ;
   private short Gx_err ;
   private String AV9TipoConCod ;
   private String AV10SubTipoConCod1 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String A39SubTipoConCod2 ;
   private String A372SubTipoConDes2 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P012O2_A38SubTipoConCod1 ;
   private String[] P012O2_A37TipoConCod ;
   private String[] P012O2_A372SubTipoConDes2 ;
   private String[] P012O2_A39SubTipoConCod2 ;
}

final  class cantidadsub2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012O2", "SELECT SubTipoConCod1, TipoConCod, SubTipoConDes2, SubTipoConCod2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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

