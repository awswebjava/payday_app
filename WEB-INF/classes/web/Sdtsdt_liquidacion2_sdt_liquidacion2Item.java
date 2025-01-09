package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_liquidacion2_sdt_liquidacion2Item extends GxUserType
{
   public Sdtsdt_liquidacion2_sdt_liquidacion2Item( )
   {
      this(  new ModelContext(Sdtsdt_liquidacion2_sdt_liquidacion2Item.class));
   }

   public Sdtsdt_liquidacion2_sdt_liquidacion2Item( ModelContext context )
   {
      super( context, "Sdtsdt_liquidacion2_sdt_liquidacion2Item");
   }

   public Sdtsdt_liquidacion2_sdt_liquidacion2Item( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_liquidacion2_sdt_liquidacion2Item");
   }

   public Sdtsdt_liquidacion2_sdt_liquidacion2Item( StructSdtsdt_liquidacion2_sdt_liquidacion2Item struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombre") )
            {
               gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdt_liquidacion2.sdt_liquidacion2Item" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNombre", gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("LiqNro", gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro, false, false);
      AddObjectProperty("LiqNombre", gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre, false, false);
   }

   public int getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro( )
   {
      return gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro ;
   }

   public void setgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro( int value )
   {
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro = value ;
   }

   public String getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre( )
   {
      return gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre ;
   }

   public void setgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre( String value )
   {
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N = (byte)(1) ;
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N ;
   }

   public web.Sdtsdt_liquidacion2_sdt_liquidacion2Item Clone( )
   {
      return (web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_liquidacion2_sdt_liquidacion2Item struct )
   {
      setgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro(struct.getLiqnro());
      setgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre(struct.getLiqnombre());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_liquidacion2_sdt_liquidacion2Item getStruct( )
   {
      web.StructSdtsdt_liquidacion2_sdt_liquidacion2Item struct = new web.StructSdtsdt_liquidacion2_sdt_liquidacion2Item ();
      struct.setLiqnro(getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro());
      struct.setLiqnombre(getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre ;
}

