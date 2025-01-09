package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getseccionpordescrip extends GXProcedure
{
   public getseccionpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getseccionpordescrip.class ), "" );
   }

   public getseccionpordescrip( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getseccionpordescrip.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getseccionpordescrip.this.AV8CliCod = aP0;
      getseccionpordescrip.this.AV10SecDescrip = aP1;
      getseccionpordescrip.this.aP2 = aP2;
      getseccionpordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug7(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "clico ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " secdescrip ", "")+AV10SecDescrip) ;
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P00LR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV10SecDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A675SecDescripSinAc = P00LR2_A675SecDescripSinAc[0] ;
         A3CliCod = P00LR2_A3CliCod[0] ;
         A13SecCodigo = P00LR2_A13SecCodigo[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV9SecCodigo = A13SecCodigo ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         new web.msgdebug7(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getseccionpordescrip.this.AV9SecCodigo;
      this.aP3[0] = getseccionpordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecCodigo = "" ;
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      P00LR2_A675SecDescripSinAc = new String[] {""} ;
      P00LR2_A3CliCod = new int[1] ;
      P00LR2_A13SecCodigo = new String[] {""} ;
      A675SecDescripSinAc = "" ;
      A13SecCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getseccionpordescrip__default(),
         new Object[] {
             new Object[] {
            P00LR2_A675SecDescripSinAc, P00LR2_A3CliCod, P00LR2_A13SecCodigo
            }
         }
      );
      AV14Pgmname = "getSeccionPorDescrip" ;
      /* GeneXus formulas. */
      AV14Pgmname = "getSeccionPorDescrip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl2 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9SecCodigo ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private boolean AV11existe ;
   private String AV10SecDescrip ;
   private String A675SecDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LR2_A675SecDescripSinAc ;
   private int[] P00LR2_A3CliCod ;
   private String[] P00LR2_A13SecCodigo ;
}

final  class getseccionpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LR2", "SELECT SecDescripSinAc, CliCod, SecCodigo FROM Seccion WHERE (CliCod = ?) AND (SecDescripSinAc = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

