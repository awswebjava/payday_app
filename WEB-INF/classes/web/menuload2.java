package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuload2 extends GXProcedure
{
   public menuload2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuload2.class ), "" );
   }

   public menuload2( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> executeUdp( short aP0 )
   {
      menuload2.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>[] aP1 )
   {
      menuload2.this.AV9EmpCod = aP0;
      menuload2.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = menuload2.this.AV12MenuLevel0;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12MenuLevel0 = new GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>(web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem.class, "K2BMultiLevelMenuItem", "PayDay", remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>[] aP1 ;
   private GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> AV12MenuLevel0 ;
}

