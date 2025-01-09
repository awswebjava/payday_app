package web ;
import com.genexus.*;

public final  class StructSdtZip implements Cloneable, java.io.Serializable
{
   public StructSdtZip( )
   {
      this( -1, new ModelContext( StructSdtZip.class ));
   }

   public StructSdtZip( int remoteHandle ,
                        ModelContext context )
   {
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

}

