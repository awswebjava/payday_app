package web ;
import com.genexus.*;

public final  class StructSdtArgon2id implements Cloneable, java.io.Serializable
{
   public StructSdtArgon2id( )
   {
      this( -1, new ModelContext( StructSdtArgon2id.class ));
   }

   public StructSdtArgon2id( int remoteHandle ,
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

