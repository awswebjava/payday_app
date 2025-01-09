package web ;
import com.genexus.*;

public final  class StructSdtbanco_old implements Cloneable, java.io.Serializable
{
   public StructSdtbanco_old( )
   {
      this( -1, new ModelContext( StructSdtbanco_old.class ));
   }

   public StructSdtbanco_old( int remoteHandle ,
                              ModelContext context )
   {
      gxTv_Sdtbanco_old_Bandescrip = "" ;
      gxTv_Sdtbanco_old_Bancuit = "" ;
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

   public String getBandescrip( )
   {
      return gxTv_Sdtbanco_old_Bandescrip ;
   }

   public void setBandescrip( String value )
   {
      gxTv_Sdtbanco_old_N = (byte)(0) ;
      gxTv_Sdtbanco_old_Bandescrip = value ;
   }

   public boolean getBanhabilitado( )
   {
      return gxTv_Sdtbanco_old_Banhabilitado ;
   }

   public void setBanhabilitado( boolean value )
   {
      gxTv_Sdtbanco_old_N = (byte)(0) ;
      gxTv_Sdtbanco_old_Banhabilitado = value ;
   }

   public String getBancuit( )
   {
      return gxTv_Sdtbanco_old_Bancuit ;
   }

   public void setBancuit( String value )
   {
      gxTv_Sdtbanco_old_N = (byte)(0) ;
      gxTv_Sdtbanco_old_Bancuit = value ;
   }

   protected byte gxTv_Sdtbanco_old_N ;
   protected String gxTv_Sdtbanco_old_Bancuit ;
   protected boolean gxTv_Sdtbanco_old_Banhabilitado ;
   protected String gxTv_Sdtbanco_old_Bandescrip ;
}

