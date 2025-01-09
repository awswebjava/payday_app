package web ;
import com.genexus.*;

public final  class StructSdtLambdaInvoker implements Cloneable, java.io.Serializable
{
   public StructSdtLambdaInvoker( )
   {
      this( -1, new ModelContext( StructSdtLambdaInvoker.class ));
   }

   public StructSdtLambdaInvoker( int remoteHandle ,
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

