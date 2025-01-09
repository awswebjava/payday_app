package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmodalidadpordescrip extends GXProcedure
{
   public getmodalidadpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmodalidadpordescrip.class ), "" );
   }

   public getmodalidadpordescrip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getmodalidadpordescrip.this.aP2 = new boolean[] {false};
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
      getmodalidadpordescrip.this.AV10MprDescrip = aP0;
      getmodalidadpordescrip.this.aP1 = aP1;
      getmodalidadpordescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002K2 */
      pr_default.execute(0, new Object[] {AV10MprDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A684MprDescripSinAc = P002K2_A684MprDescripSinAc[0] ;
         A18MprCod = P002K2_A18MprCod[0] ;
         AV9MprCod = A18MprCod ;
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
      this.aP1[0] = getmodalidadpordescrip.this.AV9MprCod;
      this.aP2[0] = getmodalidadpordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9MprCod = "" ;
      scmdbuf = "" ;
      P002K2_A684MprDescripSinAc = new String[] {""} ;
      P002K2_A18MprCod = new String[] {""} ;
      A684MprDescripSinAc = "" ;
      A18MprCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmodalidadpordescrip__default(),
         new Object[] {
             new Object[] {
            P002K2_A684MprDescripSinAc, P002K2_A18MprCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9MprCod ;
   private String scmdbuf ;
   private String A18MprCod ;
   private boolean AV11existe ;
   private String AV10MprDescrip ;
   private String A684MprDescripSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P002K2_A684MprDescripSinAc ;
   private String[] P002K2_A18MprCod ;
}

final  class getmodalidadpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002K2", "SELECT MprDescripSinAc, MprCod FROM ModalidadAFIP WHERE MprDescripSinAc = ( ?) ORDER BY MprCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}

