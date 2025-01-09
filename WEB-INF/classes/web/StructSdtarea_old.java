package web ;
import com.genexus.*;

public final  class StructSdtarea_old implements Cloneable, java.io.Serializable
{
   public StructSdtarea_old( )
   {
      this( -1, new ModelContext( StructSdtarea_old.class ));
   }

   public StructSdtarea_old( int remoteHandle ,
                             ModelContext context )
   {
      gxTv_Sdtarea_old_Secdescrip = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getSecdescrip( )
   {
      return gxTv_Sdtarea_old_Secdescrip ;
   }

   public void setSecdescrip( String value )
   {
      gxTv_Sdtarea_old_N = (byte)(0) ;
      gxTv_Sdtarea_old_Secdescrip = value ;
   }

   public boolean getSechabilitada( )
   {
      return gxTv_Sdtarea_old_Sechabilitada ;
   }

   public void setSechabilitada( boolean value )
   {
      gxTv_Sdtarea_old_N = (byte)(0) ;
      gxTv_Sdtarea_old_Sechabilitada = value ;
   }

   public boolean getSecapoopc( )
   {
      return gxTv_Sdtarea_old_Secapoopc ;
   }

   public void setSecapoopc( boolean value )
   {
      gxTv_Sdtarea_old_N = (byte)(0) ;
      gxTv_Sdtarea_old_Secapoopc = value ;
   }

   protected byte gxTv_Sdtarea_old_N ;
   protected boolean gxTv_Sdtarea_old_Sechabilitada ;
   protected boolean gxTv_Sdtarea_old_Secapoopc ;
   protected String gxTv_Sdtarea_old_Secdescrip ;
}

